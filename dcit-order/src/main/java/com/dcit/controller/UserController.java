package com.dcit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.pojo.Role;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.RoleService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
 
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private WebsiteService websiteService;
	
	//列表显示
	@RequestMapping("/list")
	public String ListAllTeller(Model model){
		List<User> list = userService.findAllTeller();
		//设置网点名称
		
		model.addAttribute("userList",list);
		return "/sysadmin/user/jUserList";
	}
	
	@RequestMapping("/tocreate")
	public String addTeller(Model model){
		//显示所有网点
		List<Website> websiteList = websiteService.findAll(null);
	
		model.addAttribute("websiteList",websiteList);
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("/save")
	public String saveUser(User teller,HttpSession session){
		userService.addTeller(teller);
		return "redirect:/user/list";
	}
	
	//跳转到更新页面
	@RequestMapping("/toupdate")
	public String toUpdateUser(String userId,Model model){
		User teller = userService.queryTellerByPrimary(userId);
		model.addAttribute("teller",teller);
		
		return "/sysadmin/user/jUserUpdate";
	}
	@RequestMapping("/update")
	public String updateUser(User teller,HttpSession session){
		System.out.println(teller.toString());
		userService.updateTeller(teller);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/changeStatus")
	public String changeTellerStatus(@RequestParam("status")String status,
			@RequestParam("id") String id){
		System.out.println(status);
		System.out.println(id);
		if(status.equals("1"))
			userService.changeTellerStatus("0", id);
		else 
			userService.changeTellerStatus("1", id);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/delete")
	public String delUser(@RequestParam("userId")String[] keys){
		userService.deleteTeller(keys);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/toUserRole")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		List<Role> roleList = roleService.findAll();
		
		//回显用户角色信息
		List<String>  uRoleList = userService.finduRoleList(userId);
		
		for (Role role : roleList) {
			if(uRoleList.contains(role.getId())){
				//证明用户有该角色信息，需要回显
				role.setChecked(true);
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(roleList);
		//System.err.println(zTreeJSON);
		//为了实现新增操作，需要传id
		model.addAttribute("userId",userId);
		model.addAttribute("zTreeJSON",zTreeJSON);
		return "sysadmin/user/jUserRole";
	}
	
	
	@RequestMapping("/saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		userService.saveUserRole(userId,roleIds);
		return "redirect:/user/list";
	}
}
