package com.arvato.service;

import org.springframework.stereotype.Service;

import com.arvato.po.ausers;


public interface ausersservice {
	//�û���¼
	public ausers isLogin(ausers ausers);
	//�ж��û��Ƿ�ע��
	public ausers isjudegeadd(String userPhone);
	//ע���û�
	public void addusers(String userPhone,String userPwd);
	
	public void toupdateloginnum(String userPhone,String loginTime);
	
	public void toinitialloginnum(String userPhone);

 }
