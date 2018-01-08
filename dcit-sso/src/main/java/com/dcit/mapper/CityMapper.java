package com.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.City;

public interface CityMapper extends SysMapper<City> {
	List<City> findAll();
}
