package com.dcit.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.dcit.tool.MD5Hash;



public class AuthCredential extends  SimpleCredentialsMatcher{
	
	//重写加密处理
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		String password = String.valueOf(loginToken.getPassword());
		
		//明文加密
		String md5Password = MD5Hash.getMd5Hash(password, username);
		
		loginToken.setPassword(md5Password.toCharArray());
		
		
		
	/*	//通过token 获取用户名和密码
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		String username = userToken.getUsername();
		String password = String.valueOf(userToken.getPassword());
		
		String encryptPassword = Encrypt.getMd5(password, username);
		userToken.setPassword(encryptPassword.toCharArray());
		
		return super.doCredentialsMatch(userToken, info);*/
		return super.doCredentialsMatch(token, info);	}
}
