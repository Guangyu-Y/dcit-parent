package com.dcit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.common.util.CookieUtils;
import com.dcit.pojo.Account;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.AccountService;
import com.dcit.service.CustomerService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;
import com.dcit.service.impl.CustomerServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountservice;
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WebsiteService websiteService;
	
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";
	
	

	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Account> accountlist = accountservice.findAll();
		model.addAttribute("accountList", accountlist);
		return "/sysadmin/account/jAccountList";
	}
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		return "/sysadmin/account/jAccountCreate";
	}
	
	@RequestMapping("/save")
	public String saveAccount(Account account,Model model,HttpServletRequest request,HttpServletResponse response){
		
		
		
		if (customerservice.findCustomerByCode(account.getCustomercode())!=null) {
			String userid=CookieUtils.getCookieValue(request, userId);
			String websiteid=CookieUtils.getCookieValue(request, websiteId);
			
			User user = userService.queryTellerByPrimary(userid);
			Website website = websiteService.findWebsiteById(websiteid);
			
			account.setUsercode(user.getCode());
			account.setWebsitecode(user.getWebsitecode());
			accountservice.saveAccount(account);
			return "redirect:/account/list";
		}else{
			return "redirect:/customer/tocreate";
		}
	}
	
	@RequestMapping("/delete")
	public String deleteAccount(@RequestParam("accountId")String[] accountIds,Model model){
		
		accountservice.deleteAccount(accountIds);
		return "redirect:/account/list";
	}
	
	
}
