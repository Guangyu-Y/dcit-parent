package com.dcit.service;

import java.util.Date;
import java.util.List;

import com.dcit.pojo.Role;
import com.dcit.pojo.User;

public interface UserService {


	List<User> findAllTeller();
	
	User queryTellerByPrimary(String key);

	void addTeller(User teller);

	void updateTeller(User teller);
	
	Boolean changeTellername(String username,String id);
	
	Boolean changeTellerPassword(String username,String id);
	
	Boolean changeTellerLoginTime(Date date,String id);
	
	
	void deleteTeller(String[] keys);
	
	Boolean changeTellerStatus(String status,String id);
	
	List<User> findAll();

	void updateState(String[] userIds, int state);


	void deleteUsers(String[] userIds);

	void saveUser(User user);

	User findUserById(String userId);


	void updateUser(User user);

	void saveUserRole(String userId, String[] roleIds);

	List<String> finduRoleList(String userId);

	User findUserByU_P(String username, String password);

	//shiro通过用户名获取用户信息
	User findUserByUserName(String username);

	List<String> findPrivilegeInfoList(String userId);

	String findRoleByuserId(String userId);
	
}
