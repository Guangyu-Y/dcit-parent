package com.dcit.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.common.util.CookieUtils;
import com.dcit.pojo.LoanReturn;
import com.dcit.service.LoanReturnService;



@Controller
@RequestMapping("/returnLoan")
public class ReturnLoanController {

	@Autowired
	private LoanReturnService loanReturnService;
	private String websiteId="dcit_websiteId";

	@RequestMapping("/returnloan")
	public String returnLoan(HttpServletRequest request,Model model,LoanReturn loanReturn,String interstRate,String starttime){
		String websiteid=CookieUtils.getCookieValue(request, websiteId);
		System.out.println(websiteid);
		loanReturn.setWebsitecode(websiteid);
		loanReturnService.RecordLoanReturnInfo(loanReturn, Double.valueOf(interstRate),starttime);
		List<LoanReturn > loanReturnList = loanReturnService.listRecordLoanInfo(loanReturn.getLoancode());
		model.addAttribute("loanReturnList",loanReturnList);	
		return "/sysadmin/returnloan/jReturnLoanRecord";
	}
	
	//显示还款信息
	@RequestMapping("/loanReturnList")
	public String loanReturnList(Model model,String loancode){	
		System.out.println(loancode);
		List<LoanReturn > loanReturnList = loanReturnService.listRecordLoanInfo(loancode);
		model.addAttribute("loanReturnList",loanReturnList);	
		return "/sysadmin/returnloan/jReturnLoanRecord";
	}	
}
