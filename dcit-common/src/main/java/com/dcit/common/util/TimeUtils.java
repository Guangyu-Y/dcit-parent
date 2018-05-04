package com.dcit.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	
	public static String getNowtime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	public static String getRamdomNumber()
	{
		return System.currentTimeMillis()+"";
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}

}
