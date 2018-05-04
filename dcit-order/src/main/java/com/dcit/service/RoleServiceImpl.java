package com.dcit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.RoleMapper;
import com.dcit.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		
		return roleMapper.select(null);
	}

	@Override
	public void saveRole(Role role) {
		role.setId(UUID.randomUUID().toString());
		roleMapper.insert(role);
	}

	@Override
	public Role findRoleById(String roleId) {
		String id = roleId;
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public List<String> findRolePrivilegeList(String roleId) {
		String id = roleId;
		return roleMapper.findRolePrivilegeList(id);
	}

	@Override
	public void saveRolePrivilege(String roleId, String[] moduleIds) {
		roleMapper.deleteRolePrivilege(roleId);
		for (String moduleId : moduleIds) {
			//System.err.println(moduleId+"121111111111111111111"+roleId);
			String id = UUID.randomUUID().toString();
			roleMapper.saveRolePrivilege(id,roleId,moduleId);
		}
		
	}

	@Override
	public void deleteRole(String[] roleIds) {

		for (String roleId : roleIds) {
			Role role = new Role();
			role.setId(roleId);
			roleMapper.delete(role);
		}
	}

	@Override
	public void deleteUserRole(String[] roleIds) {
		for (String roleId : roleIds) {
			roleMapper.deleteUserRole(roleId);
		}
	}

	@Override
	public void deleteRolePrivilege(String[] roleIds) {
		for (String roleId : roleIds) {
			roleMapper.deleteRolePrivilege(roleId);
			
		}
	}

}
