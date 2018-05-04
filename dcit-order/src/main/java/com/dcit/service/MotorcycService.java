package com.dcit.service;

import java.util.List;

import com.dcit.pojo.Motorcyc;
import com.dcit.pojo.MotorcycRecord;

public interface MotorcycService {

	

	List<Motorcyc> listAllMotorcys();
	
	
	Motorcyc queryMotorcycByID(String id);
	
	Motorcyc findMotorcycByusercode(String usercode);

	void addMotorcyc(Motorcyc motorcyc);
	
	
	void delMotorcycs(String[] ids);
	
	
	void updateMotorcyc(Motorcyc motorcyc);
	
	//
    List<String> listSummaryOfAllMotorcycs();
    //向尾箱中存钱
    Boolean saveMomeyToMotorcy(String usercode,Double money);
    //向尾箱中取钱
    Boolean getMomeyFromMotorcy(String id,Double money);

	Boolean changeMotorcycUsercode(String usercode,String id);
	
	List<MotorcycRecord> listMotorcyRecord(String motorcycid,String username); 
	
	
	Boolean RecordMotorcycOperate(String id, Double money, String operatecode);


}
