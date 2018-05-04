package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Customer;

public interface CustomerService {
	List<Customer> findAll();

//	void updateState(String[] customerIds, int state);
//
//
	void deleteCustomers(String[] customerIds);
//
	void saveCustomer(Customer customer);
//
	Customer findCustomerById(String customerId);
//
//
	void updateCustomer(Customer customer);
	
	Customer findCustomerByCode(String code);
	
	Customer findCustomerByidentitycard(String cardno);
//
//	void saveCustomerRole(String customerId, String[] roleIds);
//
//	List<String> finduRoleList(String customerId);
//
//	Customer findCustomerByU_P(String customername, String password);
//
//	//shiro通过用户名获取用户信息
//	Customer findCustomerByCustomerName(String customername);
//
//	List<String> findPrivilegeInfoList(String customerId);
}
