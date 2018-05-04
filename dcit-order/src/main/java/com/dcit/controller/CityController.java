package com.dcit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.pojo.City;
import com.dcit.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController extends BaseController{
 
	@Autowired
	private CityService cityService;

	//显示所有柜员信息
	@RequestMapping("/list")
	public String ListAllTeller(Model model){
		City mycity = new City();
		List<City> list = cityService.findAllCity(mycity);
		
		for(int i=0;i<list.size();i++){
			City each = list.get(i);
			
			if(!"0".equals(each.getParentid())){
				City city = cityService.queryCityByPrimary(each.getParentid());
				each.setParentCity(cityService.queryCityByPrimary(each.getParentid()));
			}
		}
		model.addAttribute("cityList",list);
		return "/sysadmin/city/jCityList";
	}
	//根据key查询柜员信息
	
	//添加某个柜员信息
	@RequestMapping("/tocreate")
	public String addCity(Model model){
		City mycity = new City();
		List<City> list = cityService.findAllCity(mycity);
		List<City> resultList=new ArrayList<City>();
		for(City city:list){
			if("0".equals(city.getParentid())){
				resultList.add(city);
				if(ifChilds(list,city.getId())){//判断是否有子集
					List<City> childs = new ArrayList<City>();  
                    childs = getChildList(list,city.getId(),childs);  
                    resultList.addAll(childs); 
				}
			}
		}
		model.addAttribute("cityList",resultList);
		return "/sysadmin/city/jCityCreate";
	}
	//获取父id下的子集合
	private List<City> getChildList(List<City> list, String pid, List<City> reList) {
		for (City city : list) {    
            if (city.getParentid().equals(pid)) {//查询下级菜单  
                reList.add(city);  
                if (ifChilds(list, city.getId())) {  
                    getChildList(list, city.getId(), reList);  
                }  
            }  
        }  
        return reList;
	}

	//判断是否有子集
	private boolean ifChilds(List<City> list, String pid) {
		 boolean flag = false;  
	        for (City city : list) {  
	            if (city.getParentid().equals(pid)) {  
	                flag=true;  
	                break;  
	            }  
	        }  
	        return flag;  
	}
	@RequestMapping("/save")
	public String saveCity(City city,HttpSession session){
		cityService.addCity(city);
		return "redirect:/city/list";
	}
	//更新某个柜员信息
	@RequestMapping("/toupdate")
	public String toUpdateCity(String id,Model model){
		if(null==id||"".equals(id))
			return "redirect:/city/list";
		City city = cityService.queryCityByPrimary(id);
		City parentCity = cityService.queryCityByPrimary(city.getParentid());
		City mycity = new City();
		List<City> list = cityService.findAllCity(mycity);
		model.addAttribute("cityList",list);
		model.addAttribute("city",city);
		model.addAttribute("parentCity",parentCity);
		//不包含自己
		return "/sysadmin/city/jCityUpdate";
	}
	@RequestMapping("/update")
	public String updateCity(City city,HttpSession session){
//		System.out.println("controller"+city.getId()+city.getName()+city.getParentid()+city.getCode());
		cityService.updateCity(city);
		return "redirect:/city/list";
	}
	//删除某个或者多个柜员信息
	
	@RequestMapping("/delete")
	public String delCity(@RequestParam("id")String[] keys){
		cityService.deleteCity(keys);
		return "redirect:/city/list";
	}
}
