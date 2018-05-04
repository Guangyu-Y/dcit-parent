package com.dcit.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.common.util.TimeUtils;
import com.dcit.mapper.BankcardMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Bankcard;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.BankcardService;

@Service
public class BankcardServiceImpl  extends BaseService<Bankcard> implements BankcardService{
	@Autowired
	private BankcardMapper bankcardMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Bankcard> findAllBankcard(Bankcard bankcard) {
		// TODO Auto-generated method stub
		List<Bankcard> bankcardList = bankcardMapper.select(bankcard);
	
		for(int i=0;i<bankcardList.size();i++)
		{
			String websitecode = bankcardList.get(i).getWebsiteid();
			String usercode = bankcardList.get(i).getUserid();
		
			if(websitecode!=null)
			{
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				
				if(websiteList.size()>0)
				{
					
					bankcardList.get(i).setWebsite(websiteList.get(0));
				}
			}
			if(usercode!=null)
			{
				User user = new User();
				user.setCode(usercode);
				List<User> userList = userMapper.select(user);
				
				if(userList.size()>0)
				{
					bankcardList.get(i).setUser(userList.get(0));
				}
			}
		}
		return bankcardList;
	}

	@Override
	public Bankcard queryBankcardByPrimary(String key) {
		Bankcard bankcard=bankcardMapper.selectByPrimaryKey(key);
		if(null!=bankcard)
			return bankcard;
		return null;
	}

	@Override
	public void saveBankcard(Bankcard bankcard) {
		
		//如果数据库中存在，要更新操作怎么搞
		bankcard.setId(UUID.randomUUID().toString());
		String time=TimeUtils.getNowtime();
		bankcard.setCreatetime(time);
		bankcard.setBalance(0.0);
		bankcard.setCardno(TimeUtils.getRamdomNumber());
		//用身份证查询是否开户，是否是客户，并设置备注，状态
		if(iscontain(bankcard.getIdentitycard())){
			bankcard.setInfo("用户正常");
			bankcard.setState("1");
		}
		bankcardMapper.insert(bankcard);
	}

	//根据身份证查询用户
	private boolean iscontain(String identitycard) {
		if(true)
			return true;
		return false;
	}

	@Override
	public void updateBankcard(Bankcard bankcard) {
		// TODO Auto-generated method stub
		if(bankcard==null)
			return;
		bankcardMapper.updateByPrimaryKeySelective(bankcard);
	}

	@Override
	public void deleteBankcard(String[] keys) {
		// TODO Auto-generated method stub
			bankcardMapper.deleteByIDS(keys);
	}

	@Override
	public Bankcard findBankcardById(String bankcardid) {
		Bankcard bankcard = new Bankcard();
		bankcard.setCardno(bankcardid);
		List<Bankcard> bankcardList = bankcardMapper.select(bankcard);
		if(bankcardList.size()>0)
		{
			return bankcardList.get(0);
		}
		return null;
	}

	@Override
	public void updateBalanceByCode(String bankcardcode, Double balance) {
		// TODO Auto-generated method stub
		bankcardMapper.updateBalanceByCode(bankcardcode, balance);
		
	}

	

	
}
