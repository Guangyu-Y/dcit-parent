package com.dcit.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.BankcarddetailMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Bankcarddetail;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankcarddetailService;

@Service
public class BankcarddetailServiceImpl implements BankcarddetailService{

	@Autowired
	private BankcarddetailMapper bankcarddetailMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	@Override
	public List<Bankcarddetail> findAll(Bankcarddetail bankcarddetail) {
		//Bankcarddetail b = new Bankcarddetail();
		List<Bankcarddetail> bankcarddetailList = bankcarddetailMapper.select(bankcarddetail);
		for(int i=0;i<bankcarddetailList.size();i++)
		{
			String usercode = bankcarddetailList.get(i).getUsercode();
			if(usercode!=null)
			{
				User user = new User();
				user.setCode(usercode);
				List<User> userList = userMapper.select(user);
				
				if(userList.size()>0)
				{
					bankcarddetailList.get(i).setUser(userList.get(0));
				}
			}
			
			String websitecode = bankcarddetailList.get(i).getWebsitecode();
			if(websitecode!=null)
			{
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				if(websiteList.size()>0)
				{
					bankcarddetailList.get(i).setWebsite(websiteList.get(0));
				}
			}
		}
		return bankcarddetailList;
		
	}

	@Override
	public void deleteBankcarddetails(String[] bankcarddetailIds) {
		// TODO Auto-generated method stub
		for(String bankcarddetailId:bankcarddetailIds){
			bankcarddetailMapper.deleteByPrimaryKey(bankcarddetailId);
		}
		
	}

	@Override
	public void saveBankcarddetail(Bankcarddetail bankcarddetail) {
		// TODO Auto-generated method stub
		bankcarddetail.setId(UUID.randomUUID().toString());
		bankcarddetailMapper.insertSelective(bankcarddetail);
		
	}

	@Override
	public Bankcarddetail findBankcarddetailById(String BankcarddetailId) {
		Bankcarddetail bankcarddetail = new Bankcarddetail();
		bankcarddetail.setBankcardid(BankcarddetailId);
		List<Bankcarddetail> bankcarddetailList = bankcarddetailMapper.select(bankcarddetail);
		if(bankcarddetailList.size()>0)
		{
			return bankcarddetailList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void updateBankcarddetail(Bankcarddetail BankcarddetailId) {
		// TODO Auto-generated method stub
		
	}

}
