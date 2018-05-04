package com.dcit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcit.common.util.CookieUtils;
import com.dcit.common.util.TimeUtils;
import com.dcit.pojo.Bankcard;
import com.dcit.pojo.CLLoan;
import com.dcit.pojo.City;
import com.dcit.pojo.DrawdownLoan;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankcardService;
import com.dcit.service.CLLoanService;
import com.dcit.service.CityService;
import com.dcit.service.DrawdownLoanService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/drawdownloan")
public class DrawdownLoanController extends BaseController{
 
	@Autowired
	private DrawdownLoanService drawdownLoanService;
	@Autowired
	private WebsiteService websiteService;
	@Autowired
	private CLLoanService clloanservice;
	@Autowired
	private BankcardService bankcardservice;
	
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";

	//显示所有贷款发放记录
	@RequestMapping("/list")
	public String ListAllDrawdownLoan(Model model){
		List<DrawdownLoan> list = drawdownLoanService.findAll();
		System.out.println("得到数目");
	/*	if(list!=null&&list.size()>0){
			for(DrawdownLoan each:list){
				drawdownLoanService.webCodeFindwebName(each);
			}
		}*/
		model.addAttribute("list",list);
		return "/sysadmin/drawdownloan/jDrawdownLoanList";
	}
	//添加信息
	@RequestMapping("/tocreate")
	public String addLoan(HttpServletRequest request,String loancode,Model model){
		//从cookie获得webid
		String userid=CookieUtils.getCookieValue(request, userId);
		String websiteid=CookieUtils.getCookieValue(request, websiteId);
		Website website = websiteService.findWebsiteById(websiteid);
		CLLoan loan = clloanservice.findByCode(loancode);
		model.addAttribute("website",website);
		model.addAttribute("loan", loan);
		//随机生成code
		return "/sysadmin/drawdownloan/jDrawdownLoanListCreate";
	}
	//保存发放记录
	@RequestMapping("/save")
	public String saveCity(DrawdownLoan drawdownLoan,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createtime = sdf.format(date);
		drawdownLoan.setDddate(createtime);
		drawdownLoanService.addDrawdownLoan(drawdownLoan);
		//把发放表的主键放到开立表中去
		drawdownLoanService.updateStatus(drawdownLoan.getLoancode(), "是");
		bankcardservice.updateBalanceByCode(drawdownLoan.getBankcard(),drawdownLoan.getFfnumber());
		//String loanCode=drawdownLoan.getLoancode();
		return "redirect:/drawdownloan/list";
	}
	//更新信息
		@RequestMapping("/toupdate")
		public String toUpdateUser(String id,Model model){
			if(null==id||"".equals(id))
				return "redirect:/drawdownloan/list";
			DrawdownLoan drawdownLoan = drawdownLoanService.queryDrawdownLoanByPrimary(id);
			//不包含自己
//			model.addAttribute("drawdownLoan", drawdownLoan);
			return null;
		}
	//删除发放记录
	@RequestMapping("/delete")
	public String delCity(@RequestParam("id")String[] keys){
		if(keys==null||keys.length==0)
			return "redirect:/drawdownloan/list";
		drawdownLoanService.deleteDrawdownLoan(keys);;
		return "redirect:/drawdownloan/list";
	}
}
