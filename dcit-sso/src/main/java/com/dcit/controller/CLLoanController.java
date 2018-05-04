package com.dcit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.util.CookieUtils;
import com.dcit.common.util.TimeUtils;
import com.dcit.common.vo.SysResult;
import com.dcit.pojo.Bankcard;
import com.dcit.pojo.CLLoan;
import com.dcit.pojo.City;
import com.dcit.pojo.Customer;
import com.dcit.service.BankcardService;
import com.dcit.service.CLLoanService;
import com.dcit.service.CustomerService;

@Controller
@RequestMapping("/clloan")
public class CLLoanController extends BaseController{
	@Autowired
	private CLLoanService clloanservice;
	@Autowired
	private BankcardService bankcardservice;
	@Autowired
	private CustomerService customerService ;
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";

	
	@RequestMapping("/save")
	String saveCLLoan(CLLoan clloan,HttpServletRequest request,Model model){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createtime = sdf.format(date);
		String userid=CookieUtils.getCookieValue(request, userId);
		String websiteid=CookieUtils.getCookieValue(request, websiteId);
		String code = String.valueOf(System.currentTimeMillis());
		clloan.setLoancode(code);
		clloan.setLoanid(UUID.randomUUID().toString());
		clloan.setStatus("否");
		clloan.setUsercode(userid);
		clloan.setWebsitecode(websiteid);
		clloan.setRate(0.2);
		clloan.setBalance(clloan.getMoneynumber());
		clloan.setCreateTime(createtime);
		clloanservice.createCLloan(clloan);
		return "redirect:/clloan/list";
	}
	
	@RequestMapping("/delete")
	String deleteClloan(@RequestParam("loanid")String[] loanid){
		clloanservice.deleteCLLoan(loanid);
		return "redirect:/clloan/list";
	}
	
	@RequestMapping("/list")
	String findAll(Model model){
		List<CLLoan> loans = clloanservice.findAll();
		CLLoan temp = new CLLoan();
		for(int i=0;i<loans.size();i++){
			Customer customer = customerService.findCustomerByidentitycard(loans.get(i).getBorrowCode());
			String customername = customer.getChname();
			temp = loans.get(i);
			temp.setCustomername(customername);
			loans.set(i, temp);
		}
		
		model.addAttribute("loans", loans);
		return "/sysadmin/clloan/jLoanList";
	}
	
	@RequestMapping("/findone")
	String findOne(String loanid,Model model){
		
		CLLoan one = clloanservice.findOne(loanid);
		Customer customer = customerService.findCustomerByidentitycard(one.getBorrowCode());
		one.setCustomername(customer.getChname());
		model.addAttribute("one", one);
		return "/sysadmin/clloan/JLoanOne";
	}
	
	@RequestMapping("/tocreate") 
	public String toCreate(Model model){
		return "/sysadmin/clloan/jLoanCreate";
	}
	
	@RequestMapping("/returnloan")
	public String returnLoan(String loanid,Model model){
		CLLoan loan = clloanservice.findCLLoanById(loanid);
		Customer customer = customerService.findCustomerByidentitycard(loan.getBorrowCode());
		loan.setCustomername(customer.getChname());
		model.addAttribute("loan",loan);
		return "/sysadmin/returnloan/jReturnLoan";
	}
	
	@RequestMapping("/GetCard")
	@ResponseBody
	public SysResult getCard(String idcard){
		Bankcard bankcard = new Bankcard();
		bankcard.setIdentitycard(idcard);
		List<Bankcard> cards = bankcardservice.findAllBankcard(bankcard);
		if (cards.size()>0) {
			return SysResult.build(400, "查询成功", cards);
		}else{
			return SysResult.build(200, "查询失败", null);
		}
	}
	
	
}
