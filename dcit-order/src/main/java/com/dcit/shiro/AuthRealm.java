package com.dcit.shiro;

import java.util.List;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.dcit.pojo.User;
import com.dcit.service.UserService;



public class AuthRealm extends AuthorizingRealm{
	@Resource
	private UserService userService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		/**
		 * 动态获取模块信息思路
		 * 1.获取user对象，获取userID
		 * 2.通过userID，获取roleUserId
		 * 3.通过roleUserID，获取moduleRoleId
		 * 4.通过moduleRoleId，获取module.name属性
		 */
		
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
	
		List<String> priList = userService.findPrivilegeInfoList(user.getId());
		//System.out.println(priList);
		//List<String> priList = new ArrayList<String>();
		//priList.add("");
		//priList.add("基础信息");
		//priList.add("系统管理");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(priList);
		
		//得到用户对象
		/*Subject subject = SecurityUtils.getSubject();
		String username = subject.getSession().getAttribute("username").toString();
		//根据用户名查询角色信息 
		//List<String> roleList = userService.findRoleByUserName(username);
		
		List<String> roleList = new ArrayList<String>();
		roleList.add("货运管理");
		roleList.add("基础信息");
		roleList.add("系统管理");
		//创建授权管理
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//传入授权管理的集合信息
		info.addStringPermissions(roleList);
		return info;*/
		return info;
	}

	@Override
	//登陆认证模块
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//为要shiro提供用户真实的数据
		//1.通过token后去用户名和密码
		//2.通过用户名查询用户的真是信息，真实的密码
		//3.获取数据后，通过info对象返回给shiro安全管理器
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		
		User user = userService.findUserByUserName(username);
		//第一个参数：真实的用户对象，第二个参数：真实的密码，第三个参数：当前realm的名称
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		
		/*UsernamePasswordToken loginToken =  (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		User user = userService.findUserByUserName(username);
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;*/
		return info;
		
	}



	
	
	
}
