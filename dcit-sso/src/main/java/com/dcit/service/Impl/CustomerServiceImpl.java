package com.dcit.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.CustomerMapper;
import com.dcit.pojo.Customer;
import com.dcit.service.CustomerService;
import com.dcit.tool.MD5Hash;
//
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	
	
	
	public List<Customer> findAll() {
		Customer customer = new Customer();
		customer.setId("111");
		return customerMapper.findAll();
	}
//	@Override
//	public void updateState(String[] customerIds, int state) {
//
//		 customerMapper.updateState(customerIds,state);
//	}
//	
//	@Override
	public void deleteCustomers(String[] customerIds) {
		//先删从表，再删主表
		for(String customerId:customerIds){
			customerMapper.deleteByPrimaryKey(customerId);
		}
		
	}
	//@Override
	public void saveCustomer(Customer customer) {
		customer.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		//哈希md5加密
		//customer.setPassword(MD5Hash.getMd5Hash(customer.getPassword(), customer.getCustomername()));
		//customerMapper.saveCustomer(customer);
		customerMapper.insert(customer);
		
	}
//	@Override
	public Customer findCustomerById(String customerId) {
		Customer customer = new Customer();
		customer.setId(customerId);
		return customerMapper.selectByid(customerId);
		//return customerMapper.findCustomerById(customerId);
		
	}
//	
	//@Override
	public void updateCustomer(Customer customer) {

		customerMapper.updateByPrimaryKey(customer);
		
		//customerMapper.updateCustomer(customer);
		
	}
//	@Override
//	public void saveCustomerRole(String customerId, String[] roleIds) {
//		customerMapper.deleteRoleCustomers(customerId);
//		for (String roleId : roleIds) {
//			customerMapper.saveCustomerRole(customerId,roleId);
//		}
//	}
//	@Override
//	public List<String> finduRoleList(String customerId) {
//		return customerMapper.finduRoleList(customerId);
//	}
//	@Override
//	public Customer findCustomerByU_P(String customername, String password) {
//		return customerMapper.findCustomerByU_P(customername,password);
//	}
//	
//	//shiro通过用户名获取用户信息
//	@Override
//	public Customer findCustomerByCustomerName(String customername) {
//		return customerMapper.findCustomerByCustomerName(customername);
//	}
//	@Override
//	public List<String> findPrivilegeInfoList(String customerId) {
//		// TODO Auto-generated method stub
//		return customerMapper.findPrivilegeInfoList(customerId);
//	}
//	
	@Override
	public Customer findCustomerByCode(String code) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer = customerMapper.selectBycode(code);
		return customer;
	}

}
