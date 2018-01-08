package com.dcit.service;

import java.util.List;

import com.dcit.pojo.City;

public interface CityService {

	//查询所有的柜员
	List<City> findAllCity();
	//通过主键查询柜员
	City queryCityByPrimary(String key);
	//添加一个柜员
	void addCity(City city);
	//更新一个柜员信息
	void updateCity(City city);
	//删除一个或者多个柜员信息
	void deleteCity(String[] keys);
	//根据父id查询城市
	List<City> findAll(City city);
}
