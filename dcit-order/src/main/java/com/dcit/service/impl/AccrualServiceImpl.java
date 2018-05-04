package com.dcit.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromPropertyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.util.TimeUtils;
import com.dcit.mapper.AccrualMapper;
import com.dcit.mapper.BankcarddetailMapper;
import com.dcit.pojo.Accrual;
import com.dcit.pojo.Bankcarddetail;
import com.dcit.service.AccrualService;

@Service
public class AccrualServiceImpl implements AccrualService{

	@Autowired 
	private AccrualMapper accrualMapper;
	
	@Autowired 
	private BankcarddetailMapper bankcarddetailMapper;
	

	@Override
	public List<Accrual> findAll() { 
		return accrualMapper.select(null);
	}

	@Override
	public void deleteAccrual(String[] accrualIds) {
		for(String accrualId:accrualIds){
			accrualMapper.deleteByPrimaryKey(accrualId);
		}
	}

	@Override
	public void saveAccrual(Accrual accrual) {
		accrual.setId(UUID.randomUUID().toString());
		accrualMapper.insert(accrual);
	}

	@Override
	public Accrual findAccrualById(String accrualId) {
		 return accrualMapper.selectByPrimaryKey(accrualId);
	}

	@Override
	public void updateAccrual(Accrual accrual) {
		accrualMapper.updateByPrimaryKey(accrual);
	}

	

	

	@Override
	public List<Accrual> select(Accrual accrual) { 
		return accrualMapper.select(accrual);
	}

	@Override
	public Accrual findAccrualBymonth(Integer month) {
		Accrual accrual = new Accrual();
		accrual.setMonth(month);
		accrual.setMtype("0");
		List<Accrual> accrualList = accrualMapper.select(accrual);
		if(accrualList.size()>0)
		{
			return accrualList.get(0);
		}
		return null;
	}


	
	
}
