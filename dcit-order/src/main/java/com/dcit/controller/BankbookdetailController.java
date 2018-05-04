package com.dcit.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcit.common.util.AccrualUtils;
import com.dcit.common.util.CookieUtils;
import com.dcit.common.util.TimeUtils;
import com.dcit.common.vo.SysResult;
import com.dcit.pojo.Accrual;
import com.dcit.pojo.Bankbook;
import com.dcit.pojo.Bankbookdetail;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.AccrualService;
import com.dcit.service.BankbookService;
import com.dcit.service.BankbookdetailService;
import com.dcit.service.MotorcycService;
import com.dcit.service.UserService;
import com.dcit.service.WebsiteService;

@Controller
@RequestMapping("/bankbookdetail")
public class BankbookdetailController extends BaseController{
	
	@Autowired
	private BankbookdetailService bankbookdetailService;
	
	@Autowired
	private BankbookService bankbookService;
	
	@Autowired
	private WebsiteService websiteService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MotorcycService motorcycService;
	
	@Autowired
	private AccrualService accrualService;
	
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";
	
	
	@RequestMapping("/list")
	public String findAll(Model model)
	{
       
		Bankbookdetail bankbookdetail = new Bankbookdetail();
		
		List<Bankbookdetail> bankbookdetailList = bankbookdetailService.findAll(bankbookdetail);
		
		
		model.addAttribute("bankbookdetailList",bankbookdetailList);
		return "/sysadmin/bankbookdetail/jBankbookdetailList";
		
	}
	
	//查询操作
	@RequestMapping("/tosearch")
	public String searchAll(Model model,String searchbankbookid,String searchtype)
	{
       
		Bankbookdetail bankbookdetail = new Bankbookdetail();
		bankbookdetail.setMold("1");
		if(searchbankbookid!=null&&!searchbankbookid.trim().equals(""))
		{
		
			bankbookdetail.setBankcardid(searchbankbookid);
			model.addAttribute("searchbankbookid",searchbankbookid);
		}
		if(searchtype!=null&&!searchtype.equals("0"))
		{
			bankbookdetail.setType(searchtype);
			model.addAttribute("searchtype", searchtype);
		}
				
		List<Bankbookdetail> bankbookdetailList = bankbookdetailService.findAll(bankbookdetail);
		
		//System.out.println(bankbookdetailList.size()+"数目");
		model.addAttribute("bankbookdetailList",bankbookdetailList);
		return "/sysadmin/bankbookdetail/jBankbookdetailList";
		
	}
	
	//根据存折卡号 密码  金额查询相关的信息
	@RequestMapping("/findinfo")
	@ResponseBody
	public SysResult findinfo(String bankcardid,String password,Double money,String bankcarddetailid)
	{
		
		Bankbook bankbook = new Bankbook();
		bankbook.setPassword(password);
		bankbook.setCardno(bankcardid);
		
		//System.out.println(bankbookid+"   "+password);
		List<Bankbook> bankbookList = bankbookService.findAllBankbook(bankbook);
		
		//存折卡号编号正确
		if(bankbookList.size()>0)
		{
			System.out.println(bankcarddetailid);
			//得到存折详细编号
			Bankbookdetail bankbookdetail = bankbookdetailService.findBankbookdetailBycode(bankcarddetailid);
			if(bankbookdetail==null)
			{
				return SysResult.build(500, "存折详细编号不正确");
			}
			//默认活期利息
			double demandRate=0.35;
			//定义定期
			double rate=bankbookdetail.getRate();
			//定义取款金额
			double cash=money;
			//定义创建时间  String类型
			String createTime=bankbookdetail.getCreatetime();
			//存款存款周期
			Integer month=bankbookdetail.getMonth();
			//定义存款金额 数据库中金额
			Double mymoney = bankbookdetail.getMoney();
			Map<String, Object> map = AccrualUtils.depositAccrual(rate, demandRate, cash, createTime, month, money);
		
			//应该收款日期
			String withdrawaltime = (String) map.get("endTime");
		    Double withdrawalrate = (Double) map.get("accrual");
		   // System.out.println(withdrawaltime+"   "+withdrawalrate);
		    bankbookdetail.setWithdrawaltime(withdrawaltime);
		    bankbookdetail.setWithdrawalrate(withdrawalrate);
		    Double summoney = bankbookdetail.getBanlance()+withdrawalrate;
		    bankbookdetail.setSummoney(summoney);
			
			return SysResult.build(200, "成功",bankbookdetail);
		}else{
			return SysResult.build(500, "用户名密码不正确");
			
		}
	
	}
	
	//判断账号  密码是否正确
	@RequestMapping("/judgeidandpassword")
	@ResponseBody
	public SysResult juegeNoandpassword(String bankcardid,String password)
	{
		Bankbook bankbook = new Bankbook();
		bankbook.setPassword(password);
		bankbook.setCardno(bankcardid);
		
		//System.out.println(bankbookid+"   "+password);
		List<Bankbook> bankbookList = bankbookService.findAllBankbook(bankbook);
		
		if(bankbookList.size()>0)
		{
			
			return SysResult.build(200, "账号密码正确");
		}else{
			return SysResult.build(500, "用户名密码不正确");
			
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
		
		
		return "/sysadmin/bankbookdetail/jBankbookdetailCreate";
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
		//查询所有的存款利率
		Accrual accrual = new Accrual();
		accrual.setMtype("0");
		List<Accrual> accrualList = accrualService.select(accrual);
	
		model.addAttribute("accrualList", accrualList);
		return "/sysadmin/bankbookdetail/jBankbookdetailSavemoney";	
	}

	//进行存钱操作方法
	@RequestMapping("/savemoney")
	public String savemoney(Bankbookdetail bankbookdetail)
	{
		
		bankbookdetail.setId(TimeUtils.getRamdomNumber());
		bankbookdetail.setCreatetime(TimeUtils.getNowtime());
		bankbookdetail.setType("1");
		bankbookdetail.setMold("1");
		bankbookdetail.setState("0");
	    bankbookdetail.setCode(TimeUtils.getRamdomNumber());
	    bankbookdetail.setBanlance(bankbookdetail.getMoney());
		
		
		//保存
		bankbookdetailService.saveBankbookdetail(bankbookdetail);
		//增加尾箱现金操作
		//MotorcycService.
		motorcycService.saveMomeyToMotorcy(bankbookdetail.getUsercode(), bankbookdetail.getMoney());
		return "redirect:/bankbookdetail/list";
	}
	
	
	//跳转到取款页面
	@RequestMapping("/towithdrawal")
	public String towithdrawal(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		
		CommonMethod(model,request,response);
		
		
		return "/sysadmin/bankbookdetail/jBankbookdetailtowithdrawal";
	}
	
	//进行取款操作
	@RequestMapping("/withdrawal")
	public String withdrawal(Bankbookdetail bankbookdetail)
	{
		bankbookdetail.setId(TimeUtils.getRamdomNumber());
		bankbookdetail.setCreatetime(TimeUtils.getNowtime());
		bankbookdetail.setType("2");
		bankbookdetail.setMold("1");
		//判断账户余额是否有该现金 
		Bankbook bankbook = bankbookService.findBankbookById(bankbookdetail.getBankcardid());
		bankbookdetail.setEachname(null);
		bankbookdetail.setEachbankcardno(null);
		if(bankbook.getBalance()>=bankbookdetail.getMoney())
		{
			//减少尾箱现金操作
			
			Boolean flag = motorcycService.getMomeyFromMotorcy(bankbookdetail.getUsercode(), bankbookdetail.getMoney());
			if(flag)
			{
				Double money = bankbook.getBalance()-bankbookdetail.getMoney();
				bankbookdetail.setState("0");
				bankbook.setBalance(money);
			}else{
				bankbookdetail.setState("1");
				bankbookdetail.setInfo("尾箱余额不足");
			}
			
			
		}else{
			bankbookdetail.setState("1");
			bankbookdetail.setInfo("银行卡余额不足");
		}
		
		bankbookdetailService.saveBankbookdetail(bankbookdetail);
		
		
		
		return "redirect:/bankbookdetail/list";
	}
	
	
	//
	@RequestMapping("/save")
	public String saveBankbookdetail(Bankbookdetail bankbookdetail){
		bankbookdetail.setId(TimeUtils.getRamdomNumber());
		bankbookdetail.setCreatetime(TimeUtils.getNowtime());
		
		
		
		//存款操作
		if(bankbookdetail.getType().equals("1"))
		{
			//查询出该账户的余额  再次基础上加上金额
			Bankbook bankbook = bankbookService.findBankbookById(bankbookdetail.getBankcardid());
			//System.out.println(bankbook+"==="+bankbookdetail.getBankbookid());
			Double money = bankbook.getBalance()+bankbookdetail.getMoney();
			bankbook.setBalance(money);
			bankbookdetail.setState("0");
			bankbookdetail.setEachname(null);
			bankbookdetail.setEachbankcardno(null);
			
		
			bankbookService.updateBankbook(bankbook);
			//增加尾箱现金操作
			//MotorcycService.
			motorcycService.saveMomeyToMotorcy(bankbookdetail.getUsercode(), bankbookdetail.getMoney());
		}
		//取款操作
		else if(bankbookdetail.getType().equals("2"))
		{
			//判断账户余额是否有该现金 
			Bankbook bankbook = bankbookService.findBankbookById(bankbookdetail.getBankcardid());
			bankbookdetail.setEachname(null);
			bankbookdetail.setEachbankcardno(null);
			if(bankbook.getBalance()>=bankbookdetail.getMoney())
			{
				Double money = bankbook.getBalance()-bankbookdetail.getMoney();
				bankbookdetail.setState("0");
				
				bankbook.setBalance(money);
			}else{
				bankbookdetail.setState("1");
				bankbookdetail.setInfo("余额不足");
			}
			
			
		}
		//转账操作
		else if(bankbookdetail.getType().equals("3"))
		{
			//判断对方的卡号和账号名字是否正确
			Bankbook bankbook = new Bankbook();
			bankbook.setCardno(bankbookdetail.getEachbankcardno());
			bankbook.setUsername(bankbookdetail.getEachname());
			List<Bankbook> bankbookList = bankbookService.findAllBankbook(bankbook);
			//说明存在该卡号
			if(bankbookList.size()>0)
			{
				Bankbook eachbankbook = bankbookList.get(0);
				Double money = eachbankbook.getBalance()+bankbookdetail.getMoney();
				eachbankbook.setBalance(money);
				//String userId = bankbookList.get(0)
				//更新对方的卡上余额
				bankbookService.updateBankbook(eachbankbook);
				
				//更新对方明细表
				Bankbookdetail eachbankdetail = new Bankbookdetail();
				eachbankdetail.setId(TimeUtils.getRamdomNumber());
				eachbankdetail.setBankcardid(bankbookdetail.getEachbankcardno());
				eachbankdetail.setState("0");
				eachbankdetail.setType("4");
				eachbankdetail.setUsercode(bankbookdetail.getUsercode());
				eachbankdetail.setWebsitecode(bankbookdetail.getWebsitecode());
				eachbankdetail.setMoney(bankbookdetail.getMoney());
				eachbankdetail.setEachbankcardno(bankbookdetail.getBankcardid());
				Bankbook eachbankbook1 = bankbookService.findBankbookById(bankbookdetail.getBankcardid());
				eachbankdetail.setEachname(eachbankbook1.getUsername());
				bankbookdetailService.saveBankbookdetail(eachbankdetail);
				
				//修改我的存折余额信息
				Bankbook mybankbook = bankbookService.findBankbookById(bankbookdetail.getBankcardid());
				mybankbook.setBalance(mybankbook.getBalance()-bankbookdetail.getMoney());
				bankbookService.updateBankbook(mybankbook);
				bankbookdetail.setState("0");
				
			}else{
				bankbookdetail.setState("1");
				bankbookdetail.setInfo("对方卡号或用户名不正确");
			}
			
		}
		bankbookdetailService.saveBankbookdetail(bankbookdetail);
		return "redirect:/bankbookdetail/list";
	}
	
	@RequestMapping("/delete")
	public String delUser(@RequestParam("bankcarddetailId")String[] keys){
		bankbookdetailService.deleteBankcardbankbookdetail(keys);
		return "redirect:/bankbookdetail/list";
	}

}
