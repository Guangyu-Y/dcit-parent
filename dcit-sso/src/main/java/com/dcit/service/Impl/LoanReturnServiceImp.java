package com.dcit.service.Impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.CLLoanMapper;
import com.dcit.mapper.LoanReturnMapper;
import com.dcit.pojo.LoanReturn;
import com.dcit.service.LoanReturnService;
import com.dcit.tool.TimeTool;
@Service
public class LoanReturnServiceImp implements LoanReturnService{

	
    @Autowired
    private LoanReturnMapper loanReturnMapper;
    @Autowired
    private CLLoanMapper clloanmapper;
	
	@Override
	public Boolean RecordLoanReturnInfo(LoanReturn loanReturn,Double interesrRate,String starttime) {
		// TODO Auto-generated method stub
		//生成 1.returnid:还款编号     2.times:已还次数 (不写)3.returndate:还款日   4.surplusnumbe:剩余款
		//  5.interest:利息
		System.out.println(loanReturn.getSurplusnumber());
			loanReturn.setReturnid(UUID.randomUUID().toString());
			loanReturn.setReturndate(TimeTool.getTime(new Date()));
			
			//Clloan clloan = new Clloan();
			//clloan.set
			//剩余款    1.根据还款编号找  2.相减
		
			loanReturn.setSurplusnumber(loanReturn.getSurplusnumber()-loanReturn.getSumnumber());
			clloanmapper.updateBalanceByCode(loanReturn.getSurplusnumber(), loanReturn.getLoancode());
			//计算利息  1.获取贷款开立时间 2.计算天数            3.计算利息
			String loanStartdDate =starttime;
			Date dateStart=null;
			try {
				dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(loanStartdDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int LoanDayCount = getLoanDayCount(dateStart,new Date());
			loanReturn.setInterest(interesrRate*LoanDayCount*loanReturn.getSumnumber());   
			//写入数据库
			loanReturnMapper.insert(loanReturn);
			return true;
	}

	private int getLoanDayCount(Date dateStart, Date dateReturnLoan) {
		// TODO Auto-generated method stub
		int daycount = (int)(dateReturnLoan.getTime()-dateStart.getTime())/86400000;
		
		System.out.println(daycount);
		return daycount;
	}

	@Override
	public List<LoanReturn> listRecordLoanInfo(String loancode) {
		// TODO Auto-generated method stub
		LoanReturn loanReturn = new LoanReturn();
		loanReturn.setLoancode(loancode);
		List<LoanReturn> LoanReturnList = loanReturnMapper.select(loanReturn);
		return LoanReturnList;
	}
}
