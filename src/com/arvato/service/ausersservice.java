package com.arvato.service;

import org.springframework.stereotype.Service;

import com.arvato.po.ausers;


public interface ausersservice {
	//用户登录
	public ausers isLogin(ausers ausers);
	//判断用户是否注册
	public ausers isjudegeadd(String userPhone);
	//注册用户
	public void addusers(String userPhone,String userPwd);
	
	public void toupdateloginnum(String userPhone,String loginTime);
	
	public void toinitialloginnum(String userPhone);

 }
