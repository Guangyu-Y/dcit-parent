package com.dcit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.common.util.CookieUtils;
import com.dcit.pojo.Account;
import com.dcit.pojo.Bankcard;
import com.dcit.pojo.Customer;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.AccountService;
import com.dcit.service.BankcardService;
import com.dcit.service.CustomerService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/bankcard")
public class BankcardController extends BaseController{
 
	@Autowired
	private BankcardService bankcardService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private WebsiteService websiteService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";
	//显示信息
	@RequestMapping("/list")
	public String ListAllBankcard(Model model){
		Bankcard bankcard = new Bankcard();
		bankcard.setMold("0");;
		List<Bankcard> list = bankcardService.findAllBankcard(bankcard);
		model.addAttribute("bankcardList",list);
		return "/sysadmin/bankcard/jBankcardList";
	}
	//根据key查询柜员信息
	
	//添加
	@RequestMapping("/tocreate")
	public String addBankcard(Model model){
		//从cookie里面获取柜台userid 和网点websiteid
//		String customerId="1";
//		String websiteid="1";
////		Customer customer= customerService.findCustomerById(customerId);
//		Website website = websiteService.findWebsiteById(websiteid);
//		model.addAttribute("customer",customer);
//		model.addAttribute("website",website);
		Customer customer=new Customer();
		Account account=new Account();
		model.addAttribute("account", account);
		model.addAttribute("customer", customer);
		return "/sysadmin/bankcard/jBankcardToCreate";
	}
	@SuppressWarnings("unused")
	@RequestMapping("/create")
	public String createBankcard(Bankcard bankcard,Model model,HttpServletRequest request){
		//查询用户是否有这个客户和是否开户
				Customer customer=new Customer();
				String cardno=bankcard.getIdentitycard();
				customer=customerService.findCustomerByidentitycard(cardno);
				if(customer==null){//没有该用户
					System.out.println("customer==null");
					model.addAttribute("customer", customer);
					return "/sysadmin/bankcard/jBankcardToCreate";
				}
				if(customer!=null){//判断是否开户
					model.addAttribute("customer", customer);
					String customerCode=customer.getCode();//客户号
					Account account=accountService.findAccountBycustomerCode(customerCode);
					if(account==null){
						model.addAttribute("account", account);
						return "/sysadmin/bankcard/jBankcardToCreate";
					}
					//从cookie中获取柜员id 和网点ID
					String userid=CookieUtils.getCookieValue(request, userId);
					String websiteid=CookieUtils.getCookieValue(request, websiteId);
					User user=userService.findUserById(userid);
					Website website = websiteService.findWebsiteById(websiteid);
					model.addAttribute("user", user);
					model.addAttribute("website", website);
					return "/sysadmin/bankcard/jBankcardCreate";
				}
				return"redirect:/bankcard/list";
	}
	@RequestMapping("/save")
	public String saveBankcard(Bankcard bankcard,Model model){
		if(bankcard.getMold().equals("0")){
		bankcardService.saveBankcard(bankcard);
		return "redirect:/bankcard/list";
		}
		else{
			
			bankcardService.saveBankcard(bankcard);
			return "redirect:/bankbook/list";
		}
	}
	//更新某个柜员信息
	@RequestMapping("/toupdate")
	public String toUpdateUser(String id,Model model){
		if(null==id||"".equals(id))
			return "redirect:/bankcard/list";
		Bankcard bankcard = bankcardService.queryBankcardByPrimary(id);
		model.addAttribute("bankcard",bankcard);
		//不包含自己
		return "/sysadmin/bankcard/jBankcardUpdate";
	}
	@RequestMapping("/update")
	public String updateUser(Bankcard bankcard,HttpSession session){
		bankcardService.updateBankcard(bankcard);
		if(bankcard.getBalance().equals("0"))
			return "redirect:/bankcard/list";
		else
			return "redirect:/bankbook/list";
	}
//	//删除某个或者多个存折信息
//	
	@RequestMapping("/delete")
	public String delBankcard(@RequestParam("id")String[] keys){
		bankcardService.deleteBankcard(keys);
		return "redirect:/bankcard/list";
	}
}
