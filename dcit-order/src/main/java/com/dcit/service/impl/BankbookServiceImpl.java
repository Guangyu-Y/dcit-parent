package com.dcit.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.common.util.TimeUtils;
import com.dcit.mapper.BankbookMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Bankbook;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankbookService;

@Service
public class BankbookServiceImpl  extends BaseService<Bankbook> implements BankbookService{
	@Autowired
	private BankbookMapper bankbookMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Bankbook> findAllBankbook(Bankbook bankbook) {
		// TODO Auto-generated method stub
		List<Bankbook> bankbookList = bankbookMapper.select(bankbook);
	
		for(int i=0;i<bankbookList.size();i++)
		{
			String websitecode = bankbookList.get(i).getWebsiteid();
			String usercode = bankbookList.get(i).getUserid();
		
			if(websitecode!=null)
			{
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				
				if(websiteList.size()>0)
				{
					
					bankbookList.get(i).setWebsite(websiteList.get(0));
				}
			}
			if(usercode!=null)
			{
				User user = new User();
				user.setCode(usercode);
				List<User> userList = userMapper.select(user);
				
				if(userList.size()>0)
				{
					bankbookList.get(i).setUser(userList.get(0));
				}
			}
		}
		return bankbookList;
	}

	@Override
	public Bankbook queryBankbookByPrimary(String key) {
		Bankbook bankbook=bankbookMapper.selectByPrimaryKey(key);
		if(null!=bankbook)
			return bankbook;
		return null;
	}

	@Override
	public void saveBankbook(Bankbook bankbook) {
		
		//如果数据库中存在，要更新操作怎么搞
		bankbook.setId(UUID.randomUUID().toString());
		String time=TimeUtils.getNowtime();
		bankbook.setCreatetime(time);
		bankbook.setBalance(0.0);
		bankbook.setCardno(TimeUtils.getRamdomNumber());
		//用身份证查询是否开户，是否是客户，并设置备注，状态
		if(iscontain(bankbook.getIdentitycard())){
			bankbook.setInfo("用户正常");
			bankbook.setState("1");
		}
		bankbookMapper.insert(bankbook);
	}

	//根据身份证查询用户
	private boolean iscontain(String identitybook) {
		if(true)
			return true;
		return false;
	}

	@Override
	public void updateBankbook(Bankbook bankbook) {
		// TODO Auto-generated method stub
		if(bankbook==null)
			return;
		bankbookMapper.updateByPrimaryKeySelective(bankbook);
	}

	@Override
	public void deleteBankbook(String[] keys) {
		// TODO Auto-generated method stub
			bankbookMapper.deleteByIDS(keys);
	}

	@Override
	public Bankbook findBankbookById(String bankbookid) {
		Bankbook bankbook = new Bankbook();
		bankbook.setCardno(bankbookid);
		List<Bankbook> bankbookList = bankbookMapper.select(bankbook);
		if(bankbookList.size()>0)
		{
			return bankbookList.get(0);
		}
		return null;
	}

	

	
}
