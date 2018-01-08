package com.dcit.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.pojo.Account;
import com.dcit.service.AccountService;
import com.dcit.service.CustomerService;
import com.dcit.service.Impl.CustomerServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountservice;
	@Autowired
	private CustomerService customerservice;
	
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
	public String saveAccount(Account account,Model model){
		if (customerservice.findCustomerByCode(account.getCustomercode())!=null) {
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
