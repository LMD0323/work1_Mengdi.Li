package com.arvato.mapper;

import com.arvato.po.ausers;

public interface ausersMapper {
	//��¼
	public ausers toLogin(ausers ausers);
	//�ж��Ƿ�ע���
	public ausers tojudgeisadd(String userPhone);
	//ע���û�
	public int toaddusers(String userPhone,String userPwd);
	//�ж��û���¼����
	public void toupdateloginnum(String userPhone,String loginTime);
	//��ʼ���û���¼����
	public void toinitialloginnum(String userPhone);
    
}
