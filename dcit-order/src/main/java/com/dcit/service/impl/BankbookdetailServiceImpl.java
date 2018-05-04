package com.dcit.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.BankbookdetailMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Bankbookdetail;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankbookdetailService;

@Service
public class BankbookdetailServiceImpl implements BankbookdetailService{

	@Autowired
	private BankbookdetailMapper bankbookdetailMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	@Override
	public List<Bankbookdetail> findAll(Bankbookdetail bankbookdetail) {
		//Bankbookdetail b = new Bankbookdetail();
		bankbookdetail.setMold("1");
		List<Bankbookdetail> bankbookdetailList = bankbookdetailMapper.select(bankbookdetail);
		for(int i=0;i<bankbookdetailList.size();i++)
		{
			String usercode = bankbookdetailList.get(i).getUsercode();
			if(usercode!=null)
			{
				User user = new User();
				user.setCode(usercode);
				List<User> userList = userMapper.select(user);
				
				if(userList.size()>0)
				{
					bankbookdetailList.get(i).setUser(userList.get(0));
				}
			}
			
			String websitecode = bankbookdetailList.get(i).getWebsitecode();
			if(websitecode!=null)
			{
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				if(websiteList.size()>0)
				{
					bankbookdetailList.get(i).setWebsite(websiteList.get(0));
				}
			}
		}
		return bankbookdetailList;
		
	}

	@Override
	public void deleteBankbookdetails(String[] bankbookdetailIds) {
		// TODO Auto-generated method stub
		for(String bankbookdetailId:bankbookdetailIds){
			bankbookdetailMapper.deleteByPrimaryKey(bankbookdetailId);
		}
		
	}

	@Override
	public void saveBankbookdetail(Bankbookdetail bankbookdetail) {
		// TODO Auto-generated method stub
		bankbookdetail.setId(UUID.randomUUID().toString());
		bankbookdetailMapper.insertSelective(bankbookdetail);
		
	}

	@Override
	public Bankbookdetail findBankbookdetailById(String BankbookdetailId) {
		Bankbookdetail bankbookdetail = new Bankbookdetail();
		bankbookdetail.setBankcardid(BankbookdetailId);
		List<Bankbookdetail> bankbookdetailList = bankbookdetailMapper.select(bankbookdetail);
		if(bankbookdetailList.size()>0)
		{
			return bankbookdetailList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void updateBankbookdetail(Bankbookdetail BankbookdetailId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bankbookdetail findBankbookdetailBycode(String bankcarddetailcode) {
		Bankbookdetail bankbookdetail = new Bankbookdetail();
		bankbookdetail.setCode(bankcarddetailcode);
		bankbookdetail.setMold("1");
		List<Bankbookdetail> bankbookdetailList = bankbookdetailMapper.select(bankbookdetail);
		//System.out.println(bankbookdetailList.size()+"   "+bankcarddetailcode);
		if(bankbookdetailList.size()>0)
		{
			return bankbookdetailList.get(0);
		}
		return null;
	}

	@Override
	public void deleteBankcardbankbookdetail(String[] keys) {
		for(String key:keys)
		{
			bankbookdetailMapper.deleteByPrimaryKey(key);
		}
		
	}

}
