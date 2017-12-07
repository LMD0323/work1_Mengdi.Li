package com.arvato.service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.arvato.mapper.ausersMapper;
import com.arvato.po.ausers;

@Service
public class ausersserviceimpl implements ausersservice {
    
	@Autowired
	ausersMapper ausersmapper;
	
	public ausers isLogin(ausers ausers) {
		String userPwd2 = md5(ausers.getUserPwd());
		ausers.setUserPwd(userPwd2);
		return ausersmapper.toLogin(ausers);
	}
	
	
	public ausers isjudegeadd(String userPhone) {
		return ausersmapper.tojudgeisadd(userPhone);
	}


	public void addusers(String userPhone, String userPwd) {
		// TODO Auto-generated method stub
		String userPwd1=md5(userPwd);
		 ausersmapper.toaddusers(userPhone, userPwd1);
	}


	public void toupdateloginnum(String userPhone,String loginTime) {
		// TODO Auto-generated method stub
		ausersmapper.toupdateloginnum(userPhone,loginTime);
	}


	public void toinitialloginnum(String userPhone) {
		// TODO Auto-generated method stub
		ausersmapper.toinitialloginnum(userPhone);
	}
	//  π”√MD5º”√‹√‹¬Î
	public static String md5(String message) {
	    try {
	        MessageDigest md;
	        md = MessageDigest.getInstance("md5");
	        byte m5[] = md.digest(message.getBytes());
	        BASE64Encoder encoder = new BASE64Encoder();
	        return encoder.encode(m5);
	    } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return null;
	}
	

}
