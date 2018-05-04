package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Customer;

public interface CustomerService {
	List<Customer> findAll();

	void deleteCustomers(String[] customerIds);

	void saveCustomer(Customer customer);

	Customer findCustomerById(String customerId);

	void updateCustomer(Customer customer);
	
	Customer findCustomerByCode(String code);


	Customer findCustomerByidentitycard(String cardno);
}
