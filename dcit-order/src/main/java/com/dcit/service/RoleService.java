package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Role;

public interface RoleService {

	List<Role> findAll();

	void saveRole(Role role);

	Role findRoleById(String roleId);

	void updateRole(Role role);

	List<String> findRolePrivilegeList(String roleId);

	void saveRolePrivilege(String roleId, String[] moduleIds);

	void deleteRole(String[] roleIds);

	void deleteUserRole(String[] roleIds);

	void deleteRolePrivilege(String[] roleIds);

}
