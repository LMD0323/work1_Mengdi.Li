package com.arvato.mapper;

import com.arvato.po.ausers;

public interface ausersMapper {
	//登录
	public ausers toLogin(ausers ausers);
	//判断是否注册过
	public ausers tojudgeisadd(String userPhone);
	//注册用户
	public int toaddusers(String userPhone,String userPwd);
	//判断用户登录次数
	public void toupdateloginnum(String userPhone,String loginTime);
	//初始化用户登录次数
	public void toinitialloginnum(String userPhone);
    
}
