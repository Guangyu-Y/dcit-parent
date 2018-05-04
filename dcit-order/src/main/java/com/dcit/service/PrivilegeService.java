package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Privilege;

public interface PrivilegeService {

	List<Privilege> findAll();

	void deleteModules(String[] moduleIds);

	void saveModule(Privilege privilege);

	Privilege findModuleById(String moduleId);

	void updateModule(Privilege module);

	List<Privilege> findParentModule(String moduleId);

	List<Privilege> findPanrentAndChild();

}
