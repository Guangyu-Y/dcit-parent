package com.dcit.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.mapper.CityMapper;
import com.dcit.pojo.City;
import com.dcit.service.CityService;

@Service
public class CityServiceImpl  extends BaseService<City> implements CityService{
	@Autowired
	private CityMapper cityMapper;

//	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		
		return this.queryAll();
		
	}

//	@Override
	public City queryCityByPrimary(String key) {
		// TODO Auto-generated method stub 
		City city= new City();
		city.setId(key);
		List<City> list=cityMapper.select(city);
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

//	@Override
	public void addCity(City city) {
		// TODO Auto-generated method stub
		String parentCityID=city.getId();
		String cityName=city.getName();
		city.setId(UUID.randomUUID().toString());
		city.setParentid(parentCityID);
//		city.setCode(code);
		
		if(null==cityMapper.selectByPrimaryKey(city.getParentid())){
			city.setCode("1");
		}
		if(null!=cityMapper.selectByPrimaryKey(city.getParentid())){
			String sCode=cityMapper.selectByPrimaryKey(city.getParentid()).getCode();
			int code=1+Integer.valueOf(sCode);
			city.setCode(String.valueOf(code));
		}
//		System.out.println("**"+city.getId()+city.getName()+city.getParentid()+city.getCode());
		cityMapper.insert(city);
		
	}

//	@Override
	public void updateCity(City city) {
		if(city==null)
			return;
		this.updateSelective(city);
		
		
	}

//	@Override
	public void deleteCity(String[] keys) {
		cityMapper.deleteByIDS(keys);
	}

	@Override
	public List<City> findAll(City city) {
		// TODO Auto-generated method stub
		return cityMapper.select(city);
	}

	
}
