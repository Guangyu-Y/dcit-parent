package com.dcit.service;

import java.util.List;

import com.dcit.pojo.CLLoan;

public interface CLLoanService {
	List<CLLoan> findAll();
	
	CLLoan findByCode(String code);
	
	void createCLloan(CLLoan clloan);
	
	CLLoan findOne(String loanid);
	
	void deleteCLLoan(String[] loanids);
	
	CLLoan findCLLoanById(String CLLoanid);
}
