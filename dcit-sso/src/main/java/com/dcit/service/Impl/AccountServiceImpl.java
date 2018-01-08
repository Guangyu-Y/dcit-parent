package com.dcit.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.AccountMapper;
import com.dcit.pojo.Account;
import com.dcit.service.AccountService;
import com.dcit.tool.TimeTool;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountMapper.select(null);
		return accounts;
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
		account.setUsercode("此处获取柜员号");
		account.setWebsitecode("此处获取网点号");
		Date date = new java.util.Date();
		String createTime = TimeTool.getTime(date);
		account.setCreatetime(createTime);
		account.setCreatecode(String.valueOf(System.currentTimeMillis()));
		int result = accountMapper.insert(account);
		System.out.println(result);
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

}
