package com.dcit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.pojo.Privilege;
import com.dcit.service.PrivilegeService;


@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Privilege> moduleList = privilegeService.findAll();
		model.addAttribute("moduleList",moduleList);
		
		
		
		return "/sysadmin/module/jModuleList";
	}
	
	
	
	@RequestMapping("/delete")
	public String deleteModules(@RequestParam("moduleId")String[] moduleIds){
		privilegeService.deleteModules(moduleIds);
		return "redirect:/privilege/list";
	}
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		List<Privilege> parentModuleList = privilegeService.findPanrentAndChild();
	
		//System.err.println(moduleList);
		model.addAttribute("parentModuleList",parentModuleList);
		return "/sysadmin/module/jModuleCreate";
	}
	
	@RequestMapping("/save")
	public String saveModule(Privilege privilege){
		privilegeService.saveModule(privilege);
		return "redirect:/privilege/list";
	}
	
	
	
	@RequestMapping("/toupdate")
	public String toUpdate(String moduleId,Model model){
		Privilege module = privilegeService.findModuleById(moduleId);
		model.addAttribute("module",module);
		
		//准备上级模块，除了自己
		List<Privilege> parentModuleList = privilegeService.findPanrentAndChild();
		Iterator<Privilege> it = parentModuleList.iterator();
		while(it.hasNext()){
			Privilege pri = it.next();
			if(pri.getId().equals(moduleId)){
				it.remove();
			}
		}
		
		model.addAttribute("parentModuleList",parentModuleList);
		return "/sysadmin/module/jModuleUpdate";
	}
	
	@RequestMapping("/update")
	public String updateModule(Privilege module){
		privilegeService.updateModule(module);
		return "redirect:/privilege/list";
	}
	
	

}
