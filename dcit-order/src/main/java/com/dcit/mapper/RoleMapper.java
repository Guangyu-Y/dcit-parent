package com.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.Role;

public interface RoleMapper extends SysMapper<Role> {

	List<String> findRolePrivilegeList(String id);
	
	void saveRolePrivilege(@Param("id")String id,@Param("roleId")String roleId,@Param("privilegeId") String moduleId);

	void deleteRolePrivilege(String roleId);

	void deleteUserRole(String roleId);

}
