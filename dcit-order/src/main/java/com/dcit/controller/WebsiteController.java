package com.dcit.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.vo.SysResult;
import com.dcit.pojo.City;
import com.dcit.pojo.Website;
import com.dcit.service.CityService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/website")
public class WebsiteController extends BaseController {
	@Autowired
	private WebsiteService websiteService;
	@Autowired
	private CityService cityService;
	@RequestMapping("/list")
	public String findall(Model model) throws Exception{
		
		List<Website> websiteList=websiteService.findAll(null);
		model.addAttribute("websiteList", websiteList); 
		return "/sysadmin/website/jWebsiteList";
	}
	
	@RequestMapping("/tocreate")
	public String tocreate(Model model) throws Exception{
		City city = new City();
		city.setParentid("0");
		List<City> province = cityService.findAllCity(city);
		model.addAttribute("provinces",province);
		return "/sysadmin/website/jWebsiteCreate";
	}
	@RequestMapping("/save")
	public String save(Website website) throws Exception{
 
		website.setCode(System.currentTimeMillis()+"");
		websiteService.saveWebsite(website);
		return "redirect:/website/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("websiteId")String[] websiteIds){
 
		websiteService.deleteWebsite(websiteIds);
  
		return "redirect:/website/list";
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(HttpServletRequest req,String websiteId,Model model){
 
 
		Website website=websiteService.findWebsiteById(websiteId);
		City city = new City();
		city.setParentid("0");
		List<City> province = cityService.findAllCity(city);

		model.addAttribute("provinces",province);
		model.addAttribute("website",website);
		req.setAttribute("website", website); 
		return "/sysadmin/website/jWebsiteUpdate";
	}
	@RequestMapping("/update")
	public String update(Website website){ 
		websiteService.updateWebsite(website);
		
		return "redirect:/website/list";
	}
	@RequestMapping("/info")
	public String info(HttpServletRequest req,String websiteId, Model model){ 
		Website website=websiteService.findWebsiteById(websiteId);
		
		model.addAttribute("website",website);

		req.setAttribute("website", website);
		return "/sysadmin/website/jWebsiteInfo";
	}
	
	
	@RequestMapping("/GetCitys")
	@ResponseBody
	public SysResult getCitys(String parentid){
		City city = new City();
		city.setParentid(parentid);
		List<City> citys = cityService.findAllCity(city);
		if (citys.size()>0) {
			return SysResult.build(400, "查询成功", citys);
		}else{
			return SysResult.build(200, "查询失败", null);
		}
	}
}
