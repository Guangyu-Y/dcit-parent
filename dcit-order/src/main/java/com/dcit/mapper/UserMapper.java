package com.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.Role;
import com.dcit.pojo.User;

public interface UserMapper extends SysMapper<User> {
	List<User> findAll();

	void updateState(@Param("userIds")String[] userIds, @Param("state")int state);

	//void deleteUsers(String userId);

	//void saveUser(User user);

	User findUserById(String userId);

	//void updateUser(User user);

	@Insert("insert into t_user_role(id,userid,roleid) values(#{id},#{userid},#{roleid})")
	void saveUserRole(@Param("id")String id,@Param("userid")String userId,@Param("roleid") String roleId);

	void deleteRoleUsers(String userId);

	List<String> finduRoleList(String userId);

	User findUserByU_P(@Param("username")String username, @Param("password")String password);

	User findUserByUserName(String username);

	List<String> findPrivilegeInfoList(String userId);
    
	String findRoleByuserId(String userId);
}
