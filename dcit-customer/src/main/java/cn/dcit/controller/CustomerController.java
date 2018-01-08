package cn.dcit.controller;

import java.util.List;

import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dcit.pojo.Customer;
import cn.dcit.service.CustomerService;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	//CustomerService customerservice = new CustomerService();
	@RequestMapping("select-customer")
			public String select_customer(Model model,HttpServletRequest request){
			String custumerid = request.getParameter("customerid");
			Customer customer = customerservice.selectCustomerById(custumerid);
			model.addAttribute("customer",customer);
			return "view";
		}
	
	
}
