package com.dcit.controller;

import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dcit.pojo.User;
import com.dcit.service.UserService;
import com.dcit.service.Impl.UserServiceImpl;

//
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		return "/sysadmin/user/jUserList";
	}
	
	
	
	@RequestMapping("/delete")
	public String delUser(@RequestParam("userId")String[] userIds){
		userService.deleteUsers(userIds);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/tocreate") 
	public String toCreate(Model model){
		
		
		
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("/save")
	public String saveUser(User user,HttpSession session){
		userService.saveUser(user);
		return "redirect:/user/list";
	}
	
	
	
	
	
	@RequestMapping("/toupdate")
	public String toUpdateUser(String userId,Model model){
		User user = userService.findUserById(userId);
		model.addAttribute("user",user);
		//不包含自己
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("/update")
	public String updateUser(User user,HttpSession session){
		userService.updateUser(user);
		return "redirect:/user/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
