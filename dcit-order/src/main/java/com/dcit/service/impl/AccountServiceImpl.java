package com.dcit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.util.CookieUtils;
import com.dcit.mapper.AccountMapper;
import com.dcit.mapper.CustomerMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Account;
import com.dcit.pojo.Customer;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.AccountService;
import com.dcit.tool.TimeTool;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	private String userId="dcit_userId";
	private String websiteId="dcit_websiteId";
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		List<Account> accountList = accountMapper.select(null);
		for(int i=0;i<accountList.size();i++)
		{
			String usercode = accountList.get(i).getUsercode();
			if(usercode!=null)
			{
				User user = new User();
				user.setCode(usercode);
				List<User> userList = userMapper.select(user);
				if(userList.size()>0)
				{
					accountList.get(i).setUser(userList.get(0));
				}
			}
			String customercode = accountList.get(i).getCustomercode();
			if(customercode!=null)
			{
				Customer customer = new Customer();
				customer.setCode(customercode);
				List<Customer> customerList = customerMapper.select(customer);
				
				if(customerList.size()>0)
				{
					accountList.get(i).setCustomer(customerList.get(0));
				}
			}
			String websitecode = accountList.get(i).getWebsitecode();
			if(websitecode!=null)
			{
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				if(websiteList.size()>0)
				{
					accountList.get(i).setWebsite(websiteList.get(0));
				}
			}
			
			
		
		}
		return accountList;
	}

	@Override
	public void deleteAccount(String[] accountids) {
		// TODO Auto-generated method stub
		accountMapper.deleteByIDS(accountids);
		
	}

	@Override
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		account.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		//account.setUsercode("此处获取柜员号");
		//account.setWebsitecode("此处获取网点号");
		
		
		Date date = new java.util.Date();
		String createTime = TimeTool.getTime(date);
		account.setCreatetime(createTime);
		account.setCreatecode(String.valueOf(System.currentTimeMillis()));
		int result = accountMapper.insert(account);
		//System.out.println(result);
	}

	@Override
	public Account findAccountById(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findAccountBycustomerCode(String customercode) {
		Account account = new Account();
		account.setCustomercode(customercode);
		List<Account> accountList = accountMapper.select(account);
		if(accountList.size()>0)
		{
			return accountList.get(0);
		}
		return null;
	}

}
