package com.dcit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.mapper.CLLoanMapper;
import com.dcit.pojo.CLLoan;
import com.dcit.service.CLLoanService;
@Service
public class CLLoanServiceImpl extends BaseService<CLLoan> implements CLLoanService{

	@Autowired
	private CLLoanMapper clloanmapper;
	@Override
	public List<CLLoan> findAll() {
		// TODO Auto-generated method stub
		List<CLLoan> loans = clloanmapper.findAll();
		return loans;
	}

	@Override
	public CLLoan findByCode(String code) {
		// TODO Auto-generated method stub
		return clloanmapper.findOneBycode(code);
	}

	@Override
	public void createCLloan(CLLoan clloan) {
		clloanmapper.insert(clloan);
		// TODO Auto-generated method stub
		
	}

	@Override
	public CLLoan findOne(String loanid) {
		// TODO Auto-generated method stub
		CLLoan res = clloanmapper.findOne(loanid);
		return res;
	}

	@Override
	public void deleteCLLoan(String[] loanids) {
		// TODO Auto-generated method stub
		clloanmapper.deleteByIDS(loanids);
		
	}

	@Override
	public CLLoan findCLLoanById(String CLLoanid) {
		// TODO Auto-generated method stub
		CLLoan loan = clloanmapper.findOne(CLLoanid);
		return loan;
	}

}
