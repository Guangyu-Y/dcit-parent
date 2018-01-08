package com.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.dcit.common.mapper.SysMapper;

import com.dcit.pojo.User;


public interface UserMapper extends SysMapper<User>{
	
	//List<User> findAll();

	void updateState(@Param("userIds")String[] userIds, @Param("state")int state);

	//void deleteUsers(String userId);

	//void saveUser(User user);

	User findUserById(String userId);

	//void updateUser(User user);

	@Insert("insert into role_user_p(role_id,user_id) values(#{roleId},#{userId})")
	void saveUserRole(@Param("userId")String userId,@Param("roleId") String roleId);

	void deleteRoleUsers(String userId);

	List<String> finduRoleList(String userId);

	User findUserByU_P(@Param("username")String username, @Param("password")String password);

	User findUserByUserName(String username);

	List<String> findPrivilegeInfoList(String userId);


}
