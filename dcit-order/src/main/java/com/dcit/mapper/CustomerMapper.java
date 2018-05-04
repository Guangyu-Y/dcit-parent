package com.dcit.mapper;

import com.dcit.pojo.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dcit.common.mapper.SysMapper;

public interface CustomerMapper extends SysMapper<Customer>{
    @Select("select * from t_customer")
    List<Customer> findAll();
    
    @Select("select * from t_customer where id=#{customerid}")
    Customer selectByid(@Param("customerid")String custumerid);
    
    @Select("select * from t_customer where code=#{customercode}")
    Customer selectBycode(@Param("customercode")String custumercode);
	
//	int countByExample(CustomerExample example);
//
//    int deleteByExample(CustomerExample example);
//
//    int deleteByPrimaryKey(String id);
//
 //   int insert(Customer record);
//
//    int insertSelective(Customer record);
//
//    List<Customer> selectByExample(CustomerExample example);
//
//    Customer selectByPrimaryKey(String id);
//
//    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);
//
//    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);
//
//    int updateByPrimaryKeySelective(Customer record);
//
//    int updateByPrimaryKey(Customer record);
}