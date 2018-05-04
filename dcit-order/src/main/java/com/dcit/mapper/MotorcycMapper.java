package com.dcit.mapper;

import com.dcit.common.mapper.SysMapper;

import com.dcit.pojo.Motorcyc;

public interface MotorcycMapper extends SysMapper<Motorcyc>  {
	
	//查询单个尾箱
	Motorcyc findMotorcycById(String id);
	
	void deleteMotorcycByID(String id);
	//更新单个尾箱
	
	void updateMotorcycByKey(Motorcyc motorcyc);
}
