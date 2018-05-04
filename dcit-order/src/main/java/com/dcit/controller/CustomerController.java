package com.dcit.controller;

import java.util.Calendar;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.vo.SysResult;
import com.dcit.pojo.City;
import com.dcit.pojo.Customer;
import com.dcit.service.CityService;
import com.dcit.service.CustomerService;

//
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CityService cityService;
	
	
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Customer> CustomerList = customerService.findAll();
		
		model.addAttribute("CustomerList",CustomerList);
		
		return "/sysadmin/customer/jCustomerList";
	}
	
	
//	
	@RequestMapping("/delete")
	public String delCustomer(@RequestParam("customerId")String[] customerIds){
		customerService.deleteCustomers(customerIds);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/tocreate") 
	public String toCreate(Model model){
		City city = new City();
		city.setParentid("0");
		List<City> province = cityService.findAllCity(city);
		model.addAttribute("provinces",province);
		return "/sysadmin/customer/jCustomerCreate";
	}
	
	@RequestMapping("/save")
	public String saveCustomer(Customer customer,HttpSession session){
		String code = String.valueOf(System.currentTimeMillis());
		customer.setCode(code);
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdateCustomer(String customerId,Model model){
		Customer customer = customerService.findCustomerById(customerId);
		City city = new City();
		city.setParentid("0");
		List<City> province = cityService.findAllCity(city);
		model.addAttribute("provinces",province);
		model.addAttribute("customer",customer);
		//不包含自己
		return "/sysadmin/customer/jCustomerUpdate";
	}
	
	@RequestMapping("/update")
	public String updateCustomer(Customer customer,HttpSession session){
		customerService.updateCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/findOne")
	public String findById(String customerId,Model model){
		Customer customer = customerService.findCustomerById(customerId);
		City cityarea = cityService.queryCityByPrimary(customer.getAreaid());
		City citycity = cityService.queryCityByPrimary(cityarea.getParentid());
		City cityprovince = cityService.queryCityByPrimary(citycity.getParentid());
		model.addAttribute("cityarea",cityarea);
		model.addAttribute("citycity",citycity);
		model.addAttribute("cityprovince",cityprovince);
		model.addAttribute("customer", customer);
		return "/sysadmin/customer/JCustomerOne";
	}
	
//	
//	
	
	@RequestMapping("/GetCitys")
	@ResponseBody
	public SysResult getCitys(String parentid){
		City city = new City();
		city.setParentid(parentid);
		List<City> citys = cityService.findAllCity(city);
		System.out.println(citys.size());
		if (citys.size()>0) {
			return SysResult.build(400, "查询成功", citys);
		}else{
			return SysResult.build(200, "查询失败", null);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
