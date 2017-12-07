package com.arvato.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.arvato.po.ausers;
import com.arvato.service.ausersservice;

@Controller
public class auserscontroller {
	@Autowired
	ausersservice ausersservice;
	String code;
	/**
	 * �û���¼
	 * @param ausers
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	/*@RequestMapping("tologin")
    public String tologin(ausers ausers,HttpServletResponse response) {
		//����������� �ж��Ƿ��¼�ɹ� 
		ausers ausers1=ausersservice.isLogin(ausers);
		if(ausers1!=null){
			return "main";
		}
		return "login";
    }*/
	@RequestMapping("tologin")
    public @ResponseBody int tologin(ausers ausers,HttpServletResponse response) throws ParseException {
		//���ݵ�¼�ֻ����жϵ�¼����
        String loginPhone = ausers.getUserPhone();
        int loginCount = ausersservice.isjudegeadd(loginPhone).getLoginNum();
        int reLoginCount = 3-loginCount;
      
        	if(loginCount<3){
            	//����������� �ж��Ƿ��¼�ɹ�
            	ausers ausers1=ausersservice.isLogin(ausers);
            	if(ausers1!=null){
        			return 4;
        		//�ڵ�¼�����ڣ������û��������������
        		}else if(ausers1==null){
        			//ִ�и����û���¼�����ۼ�1�Ĳ���
        			//��ȡ�ĵ�¼ʱ��
        			Date now = new Date(); 
        			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ 
        			String lastloginTime=dateFormat.format(now); 
        			ausersservice.toupdateloginnum(loginPhone, lastloginTime);
        			return reLoginCount;
        		}
            //��¼����Ϊ
            }else if(loginCount==3){
            	//�жϵ�ǰʱ�����û������ε�¼��ʱ���Ƿ���24Сʱ��
            	//��ȡ�����ε�¼ʧ�ܵ�ʱ��
            	String threeLogintime=ausersservice.isjudegeadd(loginPhone).getLoginTime();
            	Date now = new Date(); 
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
    			String nowtime=dateFormat.format(now); 
    			//String����ת��Ϊdata����
    	        Date date1 = dateFormat.parse(threeLogintime);
    	        Date date2 = dateFormat.parse(nowtime);
    	        //�������� ����ʱ���
    	    	int timeshours = (int) ((date2.getTime()-date1.getTime())/(24*60*60*1000));
    	    	//���ʱ������24Сʱ
    	    	if(timeshours>=1){
    	    		//���µ�¼����Ϊ0
    	    		ausersservice.toinitialloginnum(loginPhone);
    	    		return 11;
    	    	}
            	
            }
        
        
		 return loginCount;
    }
	/**
	 * ���û�ע��
	 * @param ausername
	 * @param auserpwd
	 * @return
	 */
	@RequestMapping("toaddusers")
	@ResponseBody
	public String addusers(String userPhone,String userPwd,HttpSession session){
		
		//����������� �ж����û��Ƿ��Ѿ�ע���
		ausers ausers=ausersservice.isjudegeadd(userPhone);
		
		if(ausers==null){
			if(null!=userPhone&&null!=userPwd&&""!=userPhone&&""!=userPwd){
				
				ausersservice.addusers(userPhone,userPwd);
				return "ok";
			}else{
				return "no";
			}
			
		}else{
			return "isExist";
		}
	}
}
