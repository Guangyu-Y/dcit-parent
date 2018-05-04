package com.dcit.service;

import java.util.List;

import com.dcit.pojo.City;

public interface CityService {

	//查询所有的区域
	List<City> findAllCity(City city);
	//通过主键查询区域
	City queryCityByPrimary(String key);
	//添加一个区域
	void addCity(City city);
	//更新一个区域信息
	void updateCity(City city);
	//删除一个或者多个区域信息
	void deleteCity(String[] keys);
}
