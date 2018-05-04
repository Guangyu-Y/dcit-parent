package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Bankbook;

public interface BankbookService {

	//查询所有的银行
	List<Bankbook> findAllBankbook(Bankbook bankbook);
	//通过主键查询银行卡
	Bankbook queryBankbookByPrimary(String key);
	//添加一个银行
	void saveBankbook(Bankbook bankbook);
	//更新一个银行卡信息
	void updateBankbook(Bankbook bankbook);
	//删除一个或者多个银行卡信息
	void deleteBankbook(String[] keys);
	Bankbook findBankbookById(String bankbookid);
	
}
