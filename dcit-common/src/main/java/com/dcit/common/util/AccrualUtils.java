package com.dcit.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 计算利息的相关方法
 * @authorzcg
 *
 */
public class AccrualUtils {
	
	
	
	/*
	 	rate 定期利息  
	 	demandRate 活期利息
	 	cash 取款金额
	 	creatTime 存款时间
	 	month 存款周期
	 	money 存款金额
	 	return map 应该取款时间  应得利息
	  */
	public  static Map<String,Object> depositAccrual(double rate,double demandRate,double cash,String createTime,Integer month,double money){
		 
		Map<String,Object> result = new HashMap<String,Object>();
		Integer realmonth;//存款月数
		Integer realday; //存款天数
		double accrual = 0;//利息
 		String endTime = getEndTime(createTime, month);
 		
		String now = TimeUtils.getNowtime();//获取当前时间
		String []nows = now.split(" ");//获取年月日 yy-mm-dd格式
		String []nownyr = nows[0].split("-");//获取年月日数组
		String pass = createTime;//获取存款时间
		String []passes = pass.split(" ");//获取存款年月日 yy-mm-dd格式
		String []passnyr = passes[0].split("-");//获取存款年月日数组
		
		Integer years =Integer.valueOf(nownyr[0])-Integer.valueOf(passnyr[0]);
		Integer monthes = Integer.valueOf(nownyr[1])-Integer.valueOf(passnyr[1]);
		Integer days = Integer.valueOf(nownyr[2])-Integer.valueOf(passnyr[2]);
		
		realday = years * 360 + monthes * 30 + days;
 		
		realmonth = realday / 30 ;
		Integer Month = Integer.valueOf(month);
		if(realmonth>=Month){ 
			accrual = (money*Month*30*rate)/360/100 + (money*(realday-Month*30)*rate)/360/100 ;//按定期时间算利息+超出时间活期利息
		}else if(realmonth<Month){
			accrual = (cash*realday*demandRate)/360/100 ;//提前支取部分现金按提取部分活期计算
		}
		 
		result.put("endTime", endTime);
		result.put("accrual", accrual);
		return  result;
	}
 
	/*
	 cash 贷款金额
	 rate 贷款利率
	 month 贷款周期
	 createTime 贷款时间
	 
	 return map 应该贷款时间  应得利息
	 */
	public static Map loanAccrual(double cash,double rate,Integer month,String createTime) {
		
		Map result = new HashMap();
		
		TimeUtils timeUtils = new TimeUtils();
		Integer realmonth;//贷款月数
		Integer realday; //贷款天数
		double  accrual = 0;//利息
		String endTime = getEndTime(createTime, month);
		
		String pass = createTime;//获取贷款时间
		String now = timeUtils.getNowtime();//获取目前时间
		String []nows = now.split(" ");//获取年月日 yy-mm-dd格式
		String []nownyr = nows[0].split("-");//获取年月日数组 
		String []passes = pass.split(" ");//获贷款款年月日 yy-mm-dd格式
		String []passnyr = passes[0].split("-");//获取贷款年月日数组
		
		Integer years =Integer.valueOf(nownyr[0])-Integer.valueOf(passnyr[0]);
		Integer monthes = Integer.valueOf(nownyr[1])-Integer.valueOf(passnyr[1]);
		Integer days = Integer.valueOf(nownyr[2])-Integer.valueOf(passnyr[2]);
		
		
		
		realday = years * 360 + monthes * 30 + days;
		realmonth = realday / 30 ;

		accrual = (realday * rate * cash)/360/100;
	
		result.put("endTime", endTime);
		result.put("accrual", accrual);
		return result;
	}
	
	public static String getEndTime(String createTime,Integer month){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		StringBuffer sb = new StringBuffer();
		
		String []create = createTime.split(" ");
		String []createYMD = create[0].split("-");
		
		Integer monthes = Integer.valueOf(createYMD[1])+Integer.valueOf(month);
		
		Integer years = Integer.valueOf(createYMD[0])+monthes/12;
		
		String realmonth = String.valueOf(monthes%12); 
		
		String realyear = String.valueOf(years);
		
		sb.append(realyear+"-"+realmonth+"-"+createYMD[2]+" "+create[1]);
		Date date = new Date();
		
		try {
			date =sdf.parse(sb.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sdf.format(date);
		
	}
	
}
