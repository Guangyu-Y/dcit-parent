package com.dcit.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Hash {
	
	
	public static String getMd5Hash(String password,String username){
		
		return new Md5Hash(password,username,3).toString();
		
	}
	public static void main(String[] args) {
		//e0d8d98ce65423afccb2c28d1606cf83
		//

		
		System.out.println(getMd5Hash("admin","admin"));
	}

}
