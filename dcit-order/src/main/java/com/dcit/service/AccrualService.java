package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Accrual; 

public interface AccrualService {
	List<Accrual> findAll();
	
	List<Accrual> select(Accrual accrual);
	
	void deleteAccrual(String[] accrualIds);

	void saveAccrual(Accrual accrual);

	Accrual findAccrualById(String accrualId);

	void updateAccrual(Accrual accrual);

	Accrual findAccrualBymonth(Integer month);

	
	
	
}
