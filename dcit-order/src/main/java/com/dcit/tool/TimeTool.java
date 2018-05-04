package com.dcit.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}	

//当用户进行登陆作比较