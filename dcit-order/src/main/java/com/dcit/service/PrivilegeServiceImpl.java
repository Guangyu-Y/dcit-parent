package com.dcit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.mapper.PrivilegeMapper;
import com.dcit.pojo.Privilege;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	private PrivilegeMapper privilegeMapper;

	@Override
	public List<Privilege> findAll() {
		List<Privilege> priList = privilegeMapper.findAll();
		for(int i = 0;i<priList.size();i++){
			if(priList.get(i).getParentid()!=null&&!priList.get(i).getParentid().equals("0")){
				Privilege pri = new Privilege();
				pri.setId(priList.get(i).getParentid());
				priList.get(i).setParentName(privilegeMapper.select(pri).get(0));
			}
			
		}
		return priList;
	}

	@Override
	public void deleteModules(String[] moduleIds) {
		//删除t_privilege表
		for (String string : moduleIds) {
			Privilege pri = new Privilege();
			pri.setId(string);
			privilegeMapper.delete(pri);
			
			privilegeMapper.deleteRolePri(string);
		}
		//删除t_role_privilege表
		
		
	}

	@Override
	public void saveModule(Privilege privilege) {
		privilege.setId(UUID.randomUUID().toString());
		privilegeMapper.insert(privilege);
	}

	@Override
	public Privilege findModuleById(String moduleId) {
		return privilegeMapper.selectByPrimaryKey(moduleId);
	}

	@Override
	public void updateModule(Privilege privilege) {
		privilegeMapper.updateByPrimaryKeySelective(privilege);
	}

	@Override
	public List<Privilege> findParentModule(String moduleId) {
		return null;
	}

	@Override
	public List<Privilege> findPanrentAndChild() {
		Privilege privilege = new Privilege();
		privilege.setParentid("0");
		List<Privilege> priList = privilegeMapper.select(privilege);
		//Set<Privilege> newpriList = new HashSet<Privilege>();
		List<Privilege> newpriList = new ArrayList<Privilege>();
		for(int i=0;i<priList.size();i++)
		{
			if(!newpriList.contains(priList.get(i)))
			{
				newpriList.add(priList.get(i));
			}
			
			
			Privilege childprivilege = new Privilege();
			childprivilege.setParentid(priList.get(i).getId());
			List<Privilege> childpriList = privilegeMapper.select(childprivilege);
			for(int j=0;j<childpriList.size();j++)
			{
			
				childpriList.get(j).setName("..."+childpriList.get(j).getName());
				if(!newpriList.contains(childpriList.get(j)))
				{
					newpriList.add(childpriList.get(j));
				}
				
				
				Privilege twochildprivilege = new Privilege();
				twochildprivilege.setParentid(childpriList.get(j).getId());
				List<Privilege> twochildpriList = privilegeMapper.select(twochildprivilege);
				for(int k=0;k<twochildpriList.size();k++)
				{
					twochildpriList.get(k).setName("......."+twochildpriList.get(k).getName());
					if(!newpriList.contains(twochildpriList.get(k)))
					{
						newpriList.add(twochildpriList.get(k));
					}
					
				}
			}
		}
		return newpriList;
	}

}
