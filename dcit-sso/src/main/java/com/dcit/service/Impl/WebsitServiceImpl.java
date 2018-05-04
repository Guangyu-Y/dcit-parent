package com.dcit.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.util.TimeUtils;
import com.dcit.mapper.WebsiteMapper; 
import com.dcit.pojo.Website;
import com.dcit.service.WebsiteService;

@Service
public class WebsitServiceImpl implements WebsiteService{

	@Autowired 
	private WebsiteMapper websiteMapper;
	
	
	@Override
	public List<Website> findAll(Website website) { 
		
		return websiteMapper.select(website);
	}

	@Override
	public void deleteWebsite(String[] websiteIds) {
		for(String websiteId:websiteIds){
			websiteMapper.deleteByPrimaryKey(websiteId);
		}
		
	}

	@Override
	public void saveWebsite(Website website) {
		website.setId(UUID.randomUUID().toString()); 
		TimeUtils timeUtils=new TimeUtils();  
		website.setCreatetime(timeUtils.getNowtime());
		websiteMapper.insert(website);
	}

	@Override
	public Website findWebsiteById(String websiteId) {  
		return websiteMapper.selectByPrimaryKey(websiteId);
	}

	@Override
	public void updateWebsite(Website website) { 
		TimeUtils timeUtils=new TimeUtils(); 
		website.setUpdatetime(timeUtils.getNowtime());
		websiteMapper.updateByPrimaryKeySelective(website);
	}

	@Override
	public Website findWebsiteByCode(String webCode) {
		if(null==webCode||"".equals(webCode))
			return null;
		Website website = new Website();
		website.setCode(webCode);
		List<Website> list = websiteMapper.select(website);
		if(list==null)
			return null;
		return list.get(0);
	}
}
