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
import com.dcit.pojo.Bankbook;
import com.dcit.pojo.Customer;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.AccountService;
import com.dcit.service.BankbookService;
import com.dcit.service.CustomerService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/bankbook")
public class BankbookController extends BaseController{
 
	@Autowired
	private BankbookService bankbookService;
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
	public String ListAllBankbook(Model model){
		Bankbook bankbook = new Bankbook();
		bankbook.setMold("1");;
		List<Bankbook> list = bankbookService.findAllBankbook(bankbook);
		model.addAttribute("bankbookList",list);
		return "/sysadmin/bankbook/jBankbookList";
	}
	//根据key查询柜员信息
	
	//添加
	@RequestMapping("/tocreate")
	public String addBankbook(Model model){
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
		return "/sysadmin/bankbook/jBankbookToCreate";
	}
	@SuppressWarnings("unused")
	@RequestMapping("/create")
	public String createBankbook(Bankbook bankbook,Model model,HttpServletRequest request){
		//查询用户是否有这个客户和是否开户
				Customer customer=new Customer();
				String bookno=bankbook.getIdentitycard();
				customer=customerService.findCustomerByidentitycard(bookno);
				if(customer==null){//没有该用户
					model.addAttribute("customer", customer);
					return "/sysadmin/bankbook/jBankbookToCreate";
				}
				if(customer!=null){//判断是否开户
					model.addAttribute("customer", customer);
					String customerCode=customer.getCode();//客户号
					Account account=accountService.findAccountBycustomerCode(customerCode);
					if(account==null){
						model.addAttribute("account", account);
						return "/sysadmin/bankbook/jBankbookToCreate";
					}
					//从cookie中获取柜员id 和网点ID
					String userid=CookieUtils.getCookieValue(request, userId);
					String websiteid=CookieUtils.getCookieValue(request, websiteId);
					User user=userService.findUserById(userid);
					Website website = websiteService.findWebsiteById(websiteid);
					model.addAttribute("user", user);
					model.addAttribute("website", website);
					return "/sysadmin/bankbook/jBankbookCreate";
				}
				return"redirect:/bankbook/list";
	}
	@RequestMapping("/save")
	public String saveBankbook(Bankbook bankbook,Model model){
		if(bankbook.getMold().equals("0")){
		bankbookService.saveBankbook(bankbook);
		return "redirect:/bankbook/list";
		}
		else{
			
			bankbookService.saveBankbook(bankbook);
			return "redirect:/bankbook/list";
		}
	}
	//更新某个柜员信息
	@RequestMapping("/toupdate")
	public String toUpdateUser(String id,Model model){
		if(null==id||"".equals(id))
			return "redirect:/bankbook/list";
		Bankbook bankbook = bankbookService.queryBankbookByPrimary(id);
		model.addAttribute("bankbook",bankbook);
		//不包含自己
		return "/sysadmin/bankbook/jBankbookUpdate";
	}
	@RequestMapping("/update")
	public String updateUser(Bankbook bankbook,HttpSession session){
		bankbookService.updateBankbook(bankbook);
		if(bankbook.getMold().equals("0"))
			return "redirect:/bankbook/list";
		else
			return "redirect:/bankbook/list";
	}
//	//删除某个或者多个柜员信息
//	
	@RequestMapping("/delete")
	public String delUser(@RequestParam("id")String[] keys){
		bankbookService.deleteBankbook(keys);
		return "redirect:/bankbook/list";
	}
}
