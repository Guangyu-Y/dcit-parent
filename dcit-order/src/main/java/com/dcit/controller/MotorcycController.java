package com.dcit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dcit.pojo.Motorcyc;
import com.dcit.pojo.MotorcycRecord;
import com.dcit.pojo.User;
import com.dcit.service.MotorcycService;
import com.dcit.service.UserService;

@Controller
@RequestMapping("/motorcyc")
@SessionAttributes("motorcyc")
public class MotorcycController {


	@Autowired
	private MotorcycService motorcycService;
	
	@Autowired
	private UserService tellerService;
	
	
	//显示尾箱详细信息
	@RequestMapping(value="listMotorcycOpeInfo",produces = "text/plain; charset=utf-8")
	public String listMotorcycOpeInfo(Model model,String motorcycid,String username){
	
		List<MotorcycRecord> motorcycRecordList = motorcycService.listMotorcyRecord(motorcycid,username);
		model.addAttribute("motorcycRecordList",motorcycRecordList);
		return "/sysadmin/motorcyc/jMotorcycRecord";
	}
	
	//显示所有尾箱信息
	@RequestMapping("list")
	public String listAllMotorcys(Model model){
		List<Motorcyc> motorcycs = motorcycService.listAllMotorcys();
		model.addAttribute("motorcycList",motorcycs);
		return "/sysadmin/motorcyc/jMotorcycList";
	}
	

	@RequestMapping("tocreate")
	public String GetTellerID(Model model){
		List<User> tellers = getTellerWithoutMotorcyc();
		model.addAttribute("tellers",tellers);
		return "/sysadmin/motorcyc/jMotorcycCreate";
	}
	@RequestMapping("save")
	public String addMotorcyc(String usercode,Model model){
		System.out.println(usercode);
		Motorcyc motorcyc = new Motorcyc();
		motorcyc.setUsercode(usercode);
		motorcycService.addMotorcyc(motorcyc);
		return "redirect:/motorcyc/list";
	}	
	//鍒犻櫎灏剧
	@RequestMapping("delete")
	public String delMotorcyc(@RequestParam("id")String[] ids){
		motorcycService.delMotorcycs(ids);
		return "redirect:/motorcyc/list";
	}
	//淇敼灏剧鐢ㄦ埛缂栧彿
	//1.缁欏嚭鍘熸湁灏剧鐢ㄦ埛缂栧彿
	//2.鏄剧ず鎵�鏈夋病鏈夋嫢鏈夊熬绠辩敤鎴�
	
	@RequestMapping("toupdate")
	public String toUpdateMotorcyc(String id,Model model){
		List<User> tellers = getTellerWithoutMotorcyc();
		model.addAttribute("tellers",tellers);
		
		Motorcyc motorcyc = motorcycService.queryMotorcycByID(id);
		model.addAttribute("motorcyc",motorcyc);
		model.addAttribute("usercode",motorcyc.getUsercode());
		return "/sysadmin/motorcyc/jMotorcycUpdate";
	}
	
	@RequestMapping("update")
	public String updateMotorcyc(String usercode,Model model, @ModelAttribute Motorcyc motorcyc){	
		motorcyc.setUsercode(usercode);
		System.out.println(motorcyc.toString());
		motorcycService.updateMotorcyc(motorcyc);
		return "redirect:/motorcyc/list";
	}	
	private List<User> getTellerWithoutMotorcyc(){
		
		List<User> tellers = tellerService.findAllTeller();
		List<Motorcyc> motorcycs = motorcycService.listAllMotorcys();
		//濡傛灉娣诲姞澶辫触锛岃鏄庣敤鎴峰凡鏈夊熬绠辩紪鍙�
		for(int i=0;i<motorcycs.size();i++){
			for(int j=0;j<tellers.size();j++){
				if(motorcycs.get(i).getUsercode().equals(tellers.get(j).getCode())){
					tellers.remove(j);
				}
			}
		}
		return tellers;
	}
}