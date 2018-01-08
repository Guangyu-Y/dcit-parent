package cn.dcit.service;

import cn.dcit.pojo.Customer;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dcit.mapper.CustomerMapper;
import cn.dcit.pojo.Customer;
@Service
public class CustomerService implements CusomerServiceImpl{
	@Autowired
	private CustomerMapper customerMapper;
	public Customer selectCustomerById(String customerid) {
		// TODO Auto-generated method stub
		String id = customerid;
//		Customer customer = customerMapper.findUserById(id);
//		Customer customer = customerMapper.findCustomerByID(id);
		Customer customer1 = new Customer();
		customer1.setId(id);
		List<Customer> customer = customerMapper.select(customer1);
//		int result = customerMapper.delete(customer1);
		//System.out.println(result);
		Customer res = customer.get(0);
		return res;
	}

}
