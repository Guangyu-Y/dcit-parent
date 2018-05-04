package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Bankcard;

public interface BankcardService {

	//查询所有的银行
	List<Bankcard> findAllBankcard(Bankcard bankcard);
	//通过主键查询银行卡
	Bankcard queryBankcardByPrimary(String key);
	//添加一个银行
	void saveBankcard(Bankcard bankcard);
	//更新一个银行卡信息
	void updateBankcard(Bankcard bankcard);
	//删除一个或者多个银行卡信息
	void deleteBankcard(String[] keys);
	
	Bankcard findBankcardById(String bankcardid);
	
	void updateBalanceByCode(String bankcardcode,Double balance);
	
}
