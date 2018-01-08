package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Account;;



public interface AccountService {
List<Account> findAll();

void deleteAccount(String[] accountids);

void saveAccount(Account account);

Account findAccountById(String accountId);


void updateAccount(Account account);

}
