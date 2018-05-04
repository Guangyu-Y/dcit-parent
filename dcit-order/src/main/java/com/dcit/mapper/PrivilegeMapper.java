package com.dcit.mapper;

import java.util.List;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.Privilege;

public interface PrivilegeMapper extends SysMapper<Privilege>{
	
	List<Privilege> findAll();

	void deleteRolePri(String PrivilegeId);

}
