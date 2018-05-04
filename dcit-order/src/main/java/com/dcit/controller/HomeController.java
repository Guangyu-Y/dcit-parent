package com.dcit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	

	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	//转向home的左侧页面
	@RequestMapping("/homeLeft")
	public String homeLeft(){
		return "/home/left";
	}
	
	//转向home的操作页面
	@RequestMapping("/homeMain")
	public String homeMain(){
		return "/home/main";
	}
	
	//每个主菜单都要写两个mapping，采用restful栟接字符串的方式改进
	@RequestMapping("/{modelName}Left")
	public String modelLeft(@PathVariable String modelName){
		return "/"+modelName+"/left";
	}
	
	@RequestMapping("/{modelName}Main")
	public String modelMain(@PathVariable String modelName){
		return "/"+modelName+"/main";
	}
	
	
	  //每个主菜单都要写两个mapping，自己定义采用restful栟接字符串的方式改进
		@RequestMapping("/{modelName}MyLeft")
		public String modelMyLeft(@PathVariable String modelName){
			return "/sysadmin/"+modelName+"/left";
		}
		
		@RequestMapping("/{modelName}MyMain")
		public String modelMyMain(@PathVariable String modelName){
			return "/sysadmin/"+modelName+"/main";
		}

	
	@RequestMapping("/staticfile/tomain")
	public String staticMain(){
		return "/stat/main";
	}
}
