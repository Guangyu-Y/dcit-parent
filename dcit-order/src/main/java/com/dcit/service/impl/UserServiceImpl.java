package com.dcit.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.common.util.TimeUtils;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Role;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.UserService;
import com.dcit.tool.MD5Hash;
import com.dcit.tool.TimeTool;

@Service
public class UserServiceImpl  extends BaseService<User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;

	@Override
	public List<User> findAllTeller() {
		List<User> userList = this.queryAll();
		// TODO Auto-generated method stub
		for (User user: userList) {
		
			String webcode = user.getWebsitecode();
			if(webcode!=null&&!webcode.trim().equals(""))
			{
				Website website = new Website();
				website.setCode(webcode);
				
				List<Website> websiteList = websiteMapper.select(website);
				if(websiteList.size()>0)
				{
					
				   user.setWebsite(websiteList.get(0));
				}
			}
			
		}
		return userList;
	}

	@Override
	public User queryTellerByPrimary(String key) {
		User teller = this.queryById(key);// TODO Auto-generated method stub
		return teller;
	}
	@Override
	public void addTeller(User teller) {
		//Id
		teller.setId(UUID.randomUUID().toString());
	    //localIp 
		try {
			teller.setLocalip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		teller.setCreatetime(TimeTool.getTime(new Date()));
		//code
		teller.setCode(TimeUtils.getRamdomNumber());
		teller.setPassword(MD5Hash.getMd5Hash(teller.getPassword(), teller.getUsername()));
		teller.setLastlogin("");
		this.save(teller);// TODO Auto-generated method stub
	}

	@Override
	public void updateTeller(User teller) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(teller);
	}

	@Override
	public void deleteTeller(String[] keys) {
		// TODO Auto-generated method stub
		userMapper.deleteByIDS(keys);
	}

	@Override
	public Boolean changeTellername(String username,String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changeTellerPassword(String username,String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changeTellerStatus(String status,String id) {
		// TODO Auto-generated method stub
		User teller = new User();
		teller.setId(id);
		
		teller.setStatus(status);
		updateTeller(teller);
		return true;
	}

	@Override
	public Boolean changeTellerLoginTime(Date date, String id) {
		// TODO Auto-generated method stub
		User teller = new User();
		teller.setId(id);
		teller.setLastlogin(TimeTool.getTime(date));
		updateTeller(teller);
		return true;
	}
	
	@Override
	public List<User> findAll() {
	
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
		
		return userMapper.selectByPrimaryKey(userId);
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
			String id = UUID.randomUUID().toString();
			userMapper.saveUserRole(id,userId,roleId);
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

	@Override
	public String findRoleByuserId(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findRoleByuserId(userId);
	}
	
}
