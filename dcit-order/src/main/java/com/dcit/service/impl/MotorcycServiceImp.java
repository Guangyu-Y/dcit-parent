package com.dcit.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcit.common.service.BaseService;
import com.dcit.mapper.MotorcycMapper;
import com.dcit.mapper.MotorcycRecordMapper;
import com.dcit.mapper.UserMapper;
import com.dcit.mapper.WebsiteMapper;
import com.dcit.pojo.Motorcyc;
import com.dcit.pojo.MotorcycRecord;
import com.dcit.pojo.User;
import com.dcit.pojo.Website;
import com.dcit.service.MotorcycService;
import com.dcit.tool.TimeTool;

@Service
public class MotorcycServiceImp extends BaseService<Motorcyc> implements MotorcycService{

	@Autowired
	private MotorcycMapper motorcycMapper;
	
	@Autowired
	private MotorcycRecordMapper motorcycRecordMapper;
	
	@Autowired
	private UserMapper tellerMapper;
	
	@Autowired
	private WebsiteMapper websiteMapper;
	
	@Override
	public Boolean getMomeyFromMotorcy(String usercode,Double money) {
		// TODO Auto-generated method stub
		Motorcyc motorcyc = this.findMotorcycByusercode(usercode);
		
		Double moneyupdate = motorcyc.getMoney() - money;
		if(moneyupdate<0)
		{
			return false;
		}
		motorcyc.setMoney(moneyupdate);
		updateMotorcyc(motorcyc);
		RecordMotorcycOperate(motorcyc.getId(),money,"0");
		 //
		return true;
	}

	@Override
	public Boolean saveMomeyToMotorcy(String usercode,Double money) {
		// TODO Auto-generated method stub
		//
		Motorcyc motorcyc = this.findMotorcycByusercode(usercode);
		Double moneyupdate = motorcyc.getMoney() + money;
		motorcyc.setMoney(moneyupdate);
		updateMotorcyc(motorcyc);
		//记录信息 
		RecordMotorcycOperate(motorcyc.getId(),money,"1");
		return true;
	}
	
	@Override
	public List<Motorcyc> listAllMotorcys() {
		// TODO Auto-generated method stub
		List<Motorcyc> motorcycs = this.queryAll();
		User user = new User();
		for (Motorcyc motorcyc : motorcycs) {
			user.setCode(motorcyc.getUsercode());
			List<User> users = tellerMapper.select(user);
		    if(users.size()>0)
		    {
		    	String username = users.get(0).getUsername();
				motorcyc.setUsername(username);
				String websitecode = users.get(0).getWebsitecode();
				Website website = new Website();
				website.setCode(websitecode);
				List<Website> websiteList = websiteMapper.select(website);
				if(websiteList.size()>0)
				{
					motorcyc.setWebsite(websiteList.get(0));
				}
		    }
			
		}
		return motorcycs;
	}

	@Override
	public void addMotorcyc(Motorcyc motorcyc) {
		// TODO Auto-generated method stub
		motorcyc.setId(UUID.randomUUID().toString());
		try {
			motorcyc.setLocalip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		motorcyc.setUpdatetime("");
		motorcyc.setMoney(0.00);
		motorcyc.setCreatetime(TimeTool.getTime(new Date()));
		this.save(motorcyc);
	}

	@Override
	public void delMotorcycs(String[] ids) {
		// TODO Auto-generated method stub
		motorcycMapper.deleteByIDS(ids);
	}

	@Override
	public List<String> listSummaryOfAllMotorcycs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMotorcyc(Motorcyc motorcyc) {
		// TODO Auto-generated method stub
		motorcycMapper.updateByPrimaryKeySelective(motorcyc);
	}

	@Override
	public Motorcyc queryMotorcycByID(String id) {
		// TODO Auto-generated method stub
		Motorcyc motorcyc = motorcycMapper.selectByPrimaryKey(id);
		return motorcyc;
	}

	@Override
	public Boolean changeMotorcycUsercode(String usercode,String id) {
		// TODO Auto-generated method stub
		Motorcyc motorcyc = new Motorcyc();
		motorcyc.setId(id);
		motorcyc.setUsercode(usercode);
		updateMotorcyc(motorcyc);
		return true;
	}
	@Override
	public List<MotorcycRecord> listMotorcyRecord(String motorcycid,String username) {
		MotorcycRecord motorcycRecord = new MotorcycRecord();
		//motorcycRecord.setOperateorname(username);
		motorcycRecord.setMotorcycid(motorcycid);
		List<MotorcycRecord> motorcycRecords =  motorcycRecordMapper.select(motorcycRecord);
		for(int i=0;i<motorcycRecords.size();i++)
		{
			motorcycRecords.get(i).setOperateorname(username);
		}
		return motorcycRecords;
		// TODO Auto-generated method stub
	}
	@Override
	public Boolean RecordMotorcycOperate(String motorcycid,Double money,String operatecode) {
		// TODO Auto-generated method stub
		 
		 MotorcycRecord motorcycRecord= new MotorcycRecord();
		
		 //1.资源ID
		 motorcycRecord.setId(UUID.randomUUID().toString());
		 //2.尾箱编号
		 motorcycRecord.setMotorcycid(motorcycid);
		 //3.操作时间
		 motorcycRecord.setOperatetime(TimeTool.getTime(new Date()));
		 //4.操作内容
		 String info ="";
		 if(operatecode.equals("1")) info="存入现金"+money;
		 if(operatecode.equals("0")) info="取出现金"+money;
		 motorcycRecord.setOperateinfo(info);
		 //5.尾箱现金
		 Motorcyc motorcyc = new Motorcyc();
		 motorcyc.setId(motorcycid);
		 Double  motorcyccash = motorcycMapper.select(motorcyc).get(0).getMoney();
		 motorcycRecord.setMotorcyccash(motorcyccash.toString());
		 motorcycRecordMapper.insertSelective(motorcycRecord);
		 return true;
	}

	@Override
	public Motorcyc findMotorcycByusercode(String usercode) {
		Motorcyc motorcyc = new Motorcyc();
		motorcyc.setUsercode(usercode);
		List<Motorcyc> motorcycList = motorcycMapper.select(motorcyc);
		if(motorcycList.size()>0)
		{
			return motorcycList.get(0);
		}
		return null;
	}
}