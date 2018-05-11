package com.dcit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcit.common.util.CookieUtils;
import com.dcit.pojo.Role;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;

@Controller
public class LoginController {
	//@Value("${USERID}")
	private String userId="dcit_userId";
	//@Value("${WEBSITEID}")
	private String websiteId="dcit_websiteId";
	
	@Autowired
	private WebsiteService websiteService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "/sysadmin/login/login";
	}

	@RequestMapping("/login")
	public String login(String username,String password,Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response){
			if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
				model.addAttribute("errorInfo","用户名或密码不能为空！");
				return "/sysadmin/login/login";
			}
			//通过subject进行登录操作
			Subject subject = SecurityUtils.getSubject();
			
			//token 票/令牌  包装用户名和密码  
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			//如果用户登录不正确，则shiro会报错，如果正确，执行下一行代码
			//如果登录正确，shiro会执行当前subject全部请求
			
			try {
				subject.login(token);
				//获取用户对象，存入session域
				User user = (User) subject.getPrincipal();
				String Id = user.getId();
				String roleName = userService.findRoleByuserId(Id);
				session.setAttribute("userSession", user);
				session.setAttribute("roleName", roleName);
				CookieUtils.setCookie(request, response,userId, user.getId(),60*60*24, true);
				String websitecode = user.getWebsitecode();
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteService.findAll(website);
				if(websiteList.size()>0)
				{
					//String mywebsitecode = websiteList.get(0).getId();
					CookieUtils.setCookie(request, response,websiteId, websiteList.get(0).getId(),60*60*24, true);
					
				}
				
				//System.out.println(userId+"   "+websiteId);
			    //System.out.println(user.getId()+"   "+user.getCode()+"  "+user.getWebsitecode());
				return "redirect:/home.action";
			} catch (AuthenticationException e) {
				e.printStackTrace();   //打印报错信息
				model.addAttribute("errorInfo","用户名或密码不正确！");
				return "/sysadmin/login/login";
			}
			
			/*
			//讲明文转化为密文
			String md5Password = MD5Hash.getMd5Hash(password, username);
			User user = userService.findUserByU_P(username,md5Password);
			
			if(user!=null){
				session.setAttribute("userSession", user);
				return "redirect:/home.action";
			}
			model.addAttribute("errorInfo","用户名或密码不正确！");*/

			
		}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("userSession");
		 Subject subject = SecurityUtils.getSubject();  
		    if (subject.isAuthenticated()) {  
		        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
		    }  
		return "/sysadmin/login/login";
	}
}
