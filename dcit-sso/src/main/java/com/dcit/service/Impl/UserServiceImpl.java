package com.dcit.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.UserMapper;
import com.dcit.pojo.User;
import com.dcit.service.UserService;
import com.dcit.tool.MD5Hash;
//
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public List<User> findAll() {
		User user = new User();
		user.setUsername("111");
		return userMapper.select(null);
	}
	@Override
	public void updateState(String[] userIds, int state) {

		 userMapper.updateState(userIds,state);
	}
	
	@Override
	public void deleteUsers(String[] userIds) {
		//先删从表，再删主表
		for(String userId:userIds){
			//userMapper.deleteUsers(userId);
			userMapper.deleteByPrimaryKey(userId);
		}
		
	}
	@Override
	public void saveUser(User user) {
		user.setId(UUID.randomUUID().toString());
		//哈希md5加密
		user.setPassword(MD5Hash.getMd5Hash(user.getPassword(), user.getUsername()));
		
		//userMapper.saveUser(user);
		userMapper.insert(user);
		
	}
	@Override
	public User findUserById(String userId) {
		String id = userId;
		return userMapper.selectByPrimaryKey(id);
		//return userMapper.findUserById(userId);
		
	}
	
	@Override
	public void updateUser(User user) {

		userMapper.updateByPrimaryKey(user);
		
		//userMapper.updateUser(user);
		
	}
	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		userMapper.deleteRoleUsers(userId);
		for (String roleId : roleIds) {
			userMapper.saveUserRole(userId,roleId);
		}
	}
	@Override
	public List<String> finduRoleList(String userId) {
		return userMapper.finduRoleList(userId);
	}
	@Override
	public User findUserByU_P(String username, String password) {
		return userMapper.findUserByU_P(username,password);
	}
	
	//shiro通过用户名获取用户信息
	@Override
	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}
	@Override
	public List<String> findPrivilegeInfoList(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findPrivilegeInfoList(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
