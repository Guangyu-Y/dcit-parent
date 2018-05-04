package com.dcit.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.util.CookieUtils;
import com.dcit.common.util.TimeUtils;
import com.dcit.common.vo.SysResult;
import com.dcit.pojo.Bankcard;
import com.dcit.pojo.Bankcarddetail;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankcardService;
import com.dcit.service.BankcarddetailService;
import com.dcit.service.MotorcycService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/bankcarddetail")
public class BankcarddetailController {
	
	@Autowired
	private BankcarddetailService bankcarddetailService;
	
	@Autowired
	private BankcardService bankcardService;
	
	@Autowired
	private WebsiteService websiteService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MotorcycService motorcycService;
	
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";
	
	
	@RequestMapping("/list")
	public String findAll(Model model)
	{
       
		Bankcarddetail bankcarddetail = new Bankcarddetail();
		
		List<Bankcarddetail> bankcarddetailList = bankcarddetailService.findAll(bankcarddetail);
		
		
		model.addAttribute("bankcarddetailList",bankcarddetailList);
		return "/sysadmin/bankcarddetail/jBankcarddetailList";
		
	}
	
	//查询操作
	@RequestMapping("/tosearch")
	public String searchAll(Model model,String searchbankcardid,String searchtype)
	{
       
		Bankcarddetail bankcarddetail = new Bankcarddetail();
		if(searchbankcardid!=null&&!searchbankcardid.trim().equals(""))
		{
		
			bankcarddetail.setBankcardid(searchbankcardid);
			model.addAttribute("searchbankcardid",searchbankcardid);
		}
		if(searchtype!=null&&!searchtype.equals("0"))
		{
			bankcarddetail.setType(searchtype);
			model.addAttribute("searchtype", searchtype);
		}
				
		List<Bankcarddetail> bankcarddetailList = bankcarddetailService.findAll(bankcarddetail);
		
		//System.out.println(bankcarddetailList.size()+"数目");
		model.addAttribute("bankcarddetailList",bankcarddetailList);
		return "/sysadmin/bankcarddetail/jBankcarddetailList";
		
	}
	
	@RequestMapping("/judgeidandpassword")
	@ResponseBody
	public SysResult juegeNoandpassword(String bankcardid,String password)
	{
		Bankcard bankcard = new Bankcard();
		bankcard.setPassword(password);
		bankcard.setCardno(bankcardid);
		
		//System.out.println(bankcardid+"   "+password);
		List<Bankcard> bankcardList = bankcardService.findAllBankcard(bankcard);
		
		if(bankcardList.size()>0)
		{
			Double balance = bankcardList.get(0).getBalance();
			return SysResult.build(200, balance+"");
		}else{
			return SysResult.build(500, "用户名密码不正确");
			
		}
	}
	
	
	@RequestMapping("/judgeeach")
	@ResponseBody
	public SysResult judgeeach(String eachbankcardno,String eachname)
	{
		
		Bankcard bankcard = new Bankcard();
		bankcard.setCardno(eachbankcardno);
		bankcard.setUsername(eachname);
		List<Bankcard> bankcardList = bankcardService.findAllBankcard(bankcard);
		if(bankcardList.size()>0)
		{
			return SysResult.build(200, "对方账户正确");
		}else{
			return SysResult.build(500, "对方卡号或账户名不正确");
		}
	}
	
	@RequestMapping("/tocreate") 
	public String toCreate(Model model,HttpServletRequest request){
		//从Cookie中取出userid和websiteid 暂时默认为
		String userid=CookieUtils.getCookieValue(request, userId);
		String websiteid=CookieUtils.getCookieValue(request, websiteId);
		User user = userService.queryTellerByPrimary(userid);
		Website website = websiteService.findWebsiteById(websiteid);
		
		model.addAttribute("user", user);
		model.addAttribute("website", website);
		
		
		return "/sysadmin/bankcarddetail/jBankcarddetailCreate";
	}
	
	//执行公共的方法  将userid和websiteid查询传到前台中
	public void CommonMethod(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		String userid=CookieUtils.getCookieValue(request, userId);
		String websiteid=CookieUtils.getCookieValue(request, websiteId);
		
		User user = userService.queryTellerByPrimary(userid);
		Website website = websiteService.findWebsiteById(websiteid);
		
		model.addAttribute("user", user);
		model.addAttribute("website", website);
	}
	//跳转到存钱操作页面
	@RequestMapping("/tosavemoney")
	public String tosavemoney(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		CommonMethod(model,request,response);
		return "/sysadmin/bankcarddetail/jBankcarddetailSavemoney";	
	}
	
	//进行存钱操作方法
	@RequestMapping("/savemoney")
	public String savemoney(Bankcarddetail bankcarddetail)
	{
		bankcarddetail.setId(TimeUtils.getRamdomNumber());
		bankcarddetail.setCreatetime(TimeUtils.getNowtime());
		bankcarddetail.setType("1");
		//查询出该账户的余额  再次基础上加上金额
		Bankcard bankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
		//System.out.println(bankcard+"==="+bankcarddetail.getBankcardid());
		Double money = bankcard.getBalance()+bankcarddetail.getMoney();
		bankcard.setBalance(money);
		bankcarddetail.setState("0");
		bankcarddetail.setEachname(null);
		bankcarddetail.setEachbankcardno(null);
		
	    //更新银行卡基本信息
		bankcardService.updateBankcard(bankcard);
		//保存
		bankcarddetailService.saveBankcarddetail(bankcarddetail);
		//增加尾箱现金操作
		//MotorcycService.
		motorcycService.saveMomeyToMotorcy(bankcarddetail.getUsercode(), bankcarddetail.getMoney());
		return "redirect:/bankcarddetail/list";
	}
	
	
	//跳转到取款页面
	@RequestMapping("/towithdrawal")
	public String towithdrawal(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		
		CommonMethod(model,request,response);
		return "/sysadmin/bankcarddetail/jBankcarddetailtowithdrawal";
	}
	
	//进行取款操作
	@RequestMapping("/withdrawal")
	public String withdrawal(Bankcarddetail bankcarddetail)
	{
		bankcarddetail.setId(TimeUtils.getRamdomNumber());
		bankcarddetail.setCreatetime(TimeUtils.getNowtime());
		bankcarddetail.setType("2");
		//判断账户余额是否有该现金 
		Bankcard bankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
		bankcarddetail.setEachname(null);
		bankcarddetail.setEachbankcardno(null);
		if(bankcard.getBalance()>=bankcarddetail.getMoney())
		{
			//减少尾箱现金操作
			
			Boolean flag = motorcycService.getMomeyFromMotorcy(bankcarddetail.getUsercode(), bankcarddetail.getMoney());
			if(flag)
			{
				Double money = bankcard.getBalance()-bankcarddetail.getMoney();
				bankcarddetail.setState("0");
				bankcard.setBalance(money);
			}else{
				bankcarddetail.setState("1");
				bankcarddetail.setInfo("尾箱余额不足");
			}
			
			
		}else{
			bankcarddetail.setState("1");
			bankcarddetail.setInfo("银行卡余额不足");
		}
		
		bankcarddetailService.saveBankcarddetail(bankcarddetail);
		
		
		
		return "redirect:/bankcarddetail/list";
	}
	
	//跳转到转账页面
	@RequestMapping("/totransfer")
	public String totransfer(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		CommonMethod(model,request,response);
		return "/sysadmin/bankcarddetail/jBankcarddetailtransfer";
	}
	
	//进行转账操作
	@RequestMapping("/transfer")
	public String transfer(Bankcarddetail bankcarddetail)
	{
		bankcarddetail.setId(TimeUtils.getRamdomNumber());
		bankcarddetail.setCreatetime(TimeUtils.getNowtime());
	    bankcarddetail.setType("3");
		//判断对方的卡号和账号名字是否正确
		Bankcard bankcard = new Bankcard();
		bankcard.setCardno(bankcarddetail.getEachbankcardno());
		bankcard.setUsername(bankcarddetail.getEachname());
		List<Bankcard> bankcardList = bankcardService.findAllBankcard(bankcard);
		//说明存在该卡号
		if(bankcardList.size()>0)
		{
			Bankcard eachbankcard = bankcardList.get(0);
			Double money = eachbankcard.getBalance()+bankcarddetail.getMoney();
			eachbankcard.setBalance(money);
			//String userId = bankcardList.get(0)
			//更新对方的卡上余额
			bankcardService.updateBankcard(eachbankcard);
			
			//更新对方明细表
			Bankcarddetail eachbankdetail = new Bankcarddetail();
			eachbankdetail.setId(TimeUtils.getRamdomNumber());
			eachbankdetail.setBankcardid(bankcarddetail.getEachbankcardno());
			eachbankdetail.setState("0");
			eachbankdetail.setType("4");
			eachbankdetail.setUsercode(bankcarddetail.getUsercode());
			eachbankdetail.setWebsitecode(bankcarddetail.getWebsitecode());
			eachbankdetail.setMoney(bankcarddetail.getMoney());
			eachbankdetail.setEachbankcardno(bankcarddetail.getBankcardid());
			Bankcard eachbankcard1 = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
			eachbankdetail.setEachname(eachbankcard1.getUsername());
			bankcarddetailService.saveBankcarddetail(eachbankdetail);
			
			//修改我的银行卡余额信息
			Bankcard mybankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
			mybankcard.setBalance(mybankcard.getBalance()-bankcarddetail.getMoney());
			bankcardService.updateBankcard(mybankcard);
			bankcarddetail.setState("0");
	}
		
		bankcarddetailService.saveBankcarddetail(bankcarddetail);
		return "redirect:/bankcarddetail/list";
		
	}		
	
	@RequestMapping("/save")
	public String saveBankcarddetail(Bankcarddetail bankcarddetail){
		bankcarddetail.setId(TimeUtils.getRamdomNumber());
		bankcarddetail.setCreatetime(TimeUtils.getNowtime());
		
		
		
		//存款操作
		if(bankcarddetail.getType().equals("1"))
		{
			//查询出该账户的余额  再次基础上加上金额
			Bankcard bankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
			//System.out.println(bankcard+"==="+bankcarddetail.getBankcardid());
			Double money = bankcard.getBalance()+bankcarddetail.getMoney();
			bankcard.setBalance(money);
			bankcarddetail.setState("0");
			bankcarddetail.setEachname(null);
			bankcarddetail.setEachbankcardno(null);
			
		
			bankcardService.updateBankcard(bankcard);
			//增加尾箱现金操作
			//MotorcycService.
			motorcycService.saveMomeyToMotorcy(bankcarddetail.getUsercode(), bankcarddetail.getMoney());
		}
		//取款操作
		else if(bankcarddetail.getType().equals("2"))
		{
			//判断账户余额是否有该现金 
			Bankcard bankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
			bankcarddetail.setEachname(null);
			bankcarddetail.setEachbankcardno(null);
			if(bankcard.getBalance()>=bankcarddetail.getMoney())
			{
				Double money = bankcard.getBalance()-bankcarddetail.getMoney();
				bankcarddetail.setState("0");
				
				bankcard.setBalance(money);
			}else{
				bankcarddetail.setState("1");
				bankcarddetail.setInfo("余额不足");
			}
			
			
		}
		//转账操作
		else if(bankcarddetail.getType().equals("3"))
		{
			//判断对方的卡号和账号名字是否正确
			Bankcard bankcard = new Bankcard();
			bankcard.setCardno(bankcarddetail.getEachbankcardno());
			bankcard.setUsername(bankcarddetail.getEachname());
			List<Bankcard> bankcardList = bankcardService.findAllBankcard(bankcard);
			//说明存在该卡号
			if(bankcardList.size()>0)
			{
				Bankcard eachbankcard = bankcardList.get(0);
				Double money = eachbankcard.getBalance()+bankcarddetail.getMoney();
				eachbankcard.setBalance(money);
				//String userId = bankcardList.get(0)
				//更新对方的卡上余额
				bankcardService.updateBankcard(eachbankcard);
				
				//更新对方明细表
				Bankcarddetail eachbankdetail = new Bankcarddetail();
				eachbankdetail.setId(TimeUtils.getRamdomNumber());
				eachbankdetail.setBankcardid(bankcarddetail.getEachbankcardno());
				eachbankdetail.setState("0");
				eachbankdetail.setType("4");
				eachbankdetail.setUsercode(bankcarddetail.getUsercode());
				eachbankdetail.setWebsitecode(bankcarddetail.getWebsitecode());
				eachbankdetail.setMoney(bankcarddetail.getMoney());
				eachbankdetail.setEachbankcardno(bankcarddetail.getBankcardid());
				Bankcard eachbankcard1 = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
				eachbankdetail.setEachname(eachbankcard1.getUsername());
				bankcarddetailService.saveBankcarddetail(eachbankdetail);
				
				//修改我的银行卡余额信息
				Bankcard mybankcard = bankcardService.findBankcardById(bankcarddetail.getBankcardid());
				mybankcard.setBalance(mybankcard.getBalance()-bankcarddetail.getMoney());
				bankcardService.updateBankcard(mybankcard);
				bankcarddetail.setState("0");
				
			}else{
				bankcarddetail.setState("1");
				bankcarddetail.setInfo("对方卡号或用户名不正确");
			}
			
		}
		bankcarddetailService.saveBankcarddetail(bankcarddetail);
		return "redirect:/bankcarddetail/list";
	}
	

}
