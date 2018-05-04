package com.dcit.service;

import java.util.List;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.Bankcarddetail;
import com.dcit.pojo.User;

public interface BankcarddetailService {
	
	List<Bankcarddetail> findAll(Bankcarddetail bankcarddetail);

	void deleteBankcarddetails(String[] BankcarddetailIds);

	void saveBankcarddetail(Bankcarddetail bankcarddetail);

	Bankcarddetail findBankcarddetailById(String BankcarddetailId);

	void updateBankcarddetail(Bankcarddetail BankcarddetailId);

}
