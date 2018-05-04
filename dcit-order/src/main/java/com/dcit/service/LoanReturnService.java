package com.dcit.service;

import java.util.List;

import com.dcit.pojo.LoanReturn;

public interface LoanReturnService {

	/**
	 * loanCode :贷款编号
	 * sumnumber:还款金额
	 * @return
	 */
	Boolean RecordLoanReturnInfo(LoanReturn loanReturn,Double interestRate,String starttime);
	
	List<LoanReturn> listRecordLoanInfo(String loancode);
	
	
}
