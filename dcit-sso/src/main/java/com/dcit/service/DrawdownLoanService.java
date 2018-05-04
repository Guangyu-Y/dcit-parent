package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Account;
import com.dcit.pojo.City;
import com.dcit.pojo.DrawdownLoan;




public interface DrawdownLoanService {
	
	//查询所有的贷款发放记录
	List<DrawdownLoan> findAll();
	//通过主键查询发放记录
	DrawdownLoan queryDrawdownLoanByPrimary(String loancode);
	//添加一个贷款发放记录
	void addDrawdownLoan(DrawdownLoan drawdownLoan);
	//删除一个贷款发放记录
	void deleteDrawdownLoan(String[] loancode);
	//更具网点代码查询网店名称
	void webCodeFindwebName(DrawdownLoan drawdownLoan);
}
