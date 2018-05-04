package com.dcit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.pojo.Privilege;
import com.dcit.pojo.Role;
import com.dcit.service.PrivilegeService;
import com.dcit.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList",roleList);
		return "/sysadmin/role/jRoleList";
	}
	
	@RequestMapping("/tocreate") 
	public String toCreate(Model model){
		return "/sysadmin/role/jRoleCreate";
	}
	
	@RequestMapping("/save")
	public String saveUser(Role role){
		roleService.saveRole(role);
		return "redirect:/role/list";
	}
	
	@RequestMapping("/toupdate") 
	public String toUpdate(Model model,String roleId){
		Role role = roleService.findRoleById(roleId);
		model.addAttribute("role",role);
		return "/sysadmin/role/jRoleUpdate";
	}
	
	@RequestMapping("/update")
	public String updateRole(Role role,Model model){
		roleService.updateRole(role);
		return "redirect:/role/list";
	}
	
	@RequestMapping("/toModule")
	public String toModule(String roleId,Model model) throws JsonProcessingException{
		///准备全部的
		List<Privilege> privilegeList = privilegeService.findAll();
		
		
		List<String> rolePrivilegeList = roleService.findRolePrivilegeList(roleId);
		for (Privilege privilege : privilegeList) {
			if(rolePrivilegeList.contains(privilege.getId())){
				privilege.setChecked(true);
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(privilegeList);
		
		model.addAttribute("roleId",roleId);
		model.addAttribute("zTreeJSON",zTreeJSON);
		
		return "/sysadmin/role/jRolePrivilege";
	}
	
	@RequestMapping("/saveRolePrivilege")
	public String saveRoleModule(String roleId,String[] moduleIds){
		roleService.saveRolePrivilege(roleId,moduleIds);
		
		return "redirect:/role/list";
	}
	
	@RequestMapping("/delete")
	public String deleteRole(@RequestParam("roleId")String[] roleIds){
		//根据id删除t_role记录
		roleService.deleteRole(roleIds);
		
		//根据id删除t_user_role记录
		roleService.deleteUserRole(roleIds);
		//根据id删除t_role_privilege记录
		roleService.deleteRolePrivilege(roleIds);
		return "redirect:/role/list";
	}

}
