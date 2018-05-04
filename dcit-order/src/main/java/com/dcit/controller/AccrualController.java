package com.dcit.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.vo.SysResult;
import com.dcit.pojo.Accrual;
import com.dcit.service.AccrualService;

@Controller
@RequestMapping("/accrual")
public class AccrualController {
	@Autowired
	private AccrualService accrualService;
	@RequestMapping("/list")
	public String findall(Model model) throws Exception{
		
		List<Accrual> accrualList=accrualService.findAll(); 
		
		model.addAttribute("accrualList", accrualList); 
		return "/sysadmin/accrual/jAccrualList";
	}
	
	@RequestMapping("/findborrowAccrualBymonth")
	@ResponseBody
	public SysResult findborrowAccrualBymonth(Integer month)
	{
		Accrual accrual = accrualService.findAccrualBymonth(month);
		if(accrual!=null)
		{
			return SysResult.build(200, "成功",accrual);
		}else{
			return SysResult.build(500, "失败");
		}
	}
	
	@RequestMapping("/tocreate")
	public String tocreate(Model model) throws Exception{

		return "/sysadmin/accrual/jAccrualCreate";
	}
	@RequestMapping("/save")
	public String save(Accrual accrual) throws Exception{
 
		accrualService.saveAccrual(accrual);
		return "redirect:/accrual/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("accrualId")String[] accrualIds){
 
		accrualService.deleteAccrual(accrualIds);
  
		return "redirect:/accrual/list";
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(String accrualId,Model model){
		Accrual accrual=accrualService.findAccrualById(accrualId); 
		model.addAttribute("accrual",accrual); 
		return "/sysadmin/accrual/jAccrualUpdate";
		
	}
	@RequestMapping("/update")
	public String update(Accrual accrual){ 
		accrual.setMonth(accrualService.findAccrualById(accrual.getId()).getMonth());
		accrualService.updateAccrual(accrual);
		return "redirect:/accrual/list";
	}
	@RequestMapping("/select")
	public String select(String type,Model model){ 
		
		Accrual accrual = new Accrual(); 
		accrual.setMtype(type);;
		List<Accrual> accrualList = new ArrayList<Accrual>();
		if("2".equals(type)) {
			accrualList = accrualService.findAll();
		}else{
			accrualList = accrualService.select(accrual);
		}
		model.addAttribute("accrualList",accrualList);
		model.addAttribute("type",type);
		return "/sysadmin/accrual/jAccrualList";
	}
	@RequestMapping("/test")
	public String test(Accrual accrual){ 
	 
		return "redirect:/accrual/list";
	}
}
