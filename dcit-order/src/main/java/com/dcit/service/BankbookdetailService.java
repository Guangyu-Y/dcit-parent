package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Bankbookdetail;


public interface BankbookdetailService {
	
	List<Bankbookdetail> findAll(Bankbookdetail bankbookdetail);

	void deleteBankbookdetails(String[] BankbookdetailIds);

	void saveBankbookdetail(Bankbookdetail bankbookdetail);

	Bankbookdetail findBankbookdetailById(String BankbookdetailId);

	void updateBankbookdetail(Bankbookdetail BankbookdetailId);

	Bankbookdetail findBankbookdetailBycode(String bankcarddetailid);

	void deleteBankcardbankbookdetail(String[] keys);

}
