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
	 * 用户登录
	 * @param ausers
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	/*@RequestMapping("tologin")
    public String tologin(ausers ausers,HttpServletResponse response) {
		//声明对象变量 判断是否登录成功 
		ausers ausers1=ausersservice.isLogin(ausers);
		if(ausers1!=null){
			return "main";
		}
		return "login";
    }*/
	@RequestMapping("tologin")
    public @ResponseBody int tologin(ausers ausers,HttpServletResponse response) throws ParseException {
		//根据登录手机号判断登录次数
        String loginPhone = ausers.getUserPhone();
        int loginCount = ausersservice.isjudegeadd(loginPhone).getLoginNum();
        int reLoginCount = 3-loginCount;
      
        	if(loginCount<3){
            	//声明对象变量 判断是否登录成功
            	ausers ausers1=ausersservice.isLogin(ausers);
            	if(ausers1!=null){
        			return 4;
        		//在登录次数内，但是用户名密码输入错误
        		}else if(ausers1==null){
        			//执行更新用户登录次数累加1的操作
        			//获取的登录时间
        			Date now = new Date(); 
        			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式 
        			String lastloginTime=dateFormat.format(now); 
        			ausersservice.toupdateloginnum(loginPhone, lastloginTime);
        			return reLoginCount;
        		}
            //登录次数为
            }else if(loginCount==3){
            	//判断当前时间与用户第三次登录的时间是否在24小时内
            	//获取第三次登录失败的时间
            	String threeLogintime=ausersservice.isjudegeadd(loginPhone).getLoginTime();
            	Date now = new Date(); 
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
    			String nowtime=dateFormat.format(now); 
    			//String类型转化为data类型
    	        Date date1 = dateFormat.parse(threeLogintime);
    	        Date date2 = dateFormat.parse(nowtime);
    	        //声明变量 计算时间差
    	    	int timeshours = (int) ((date2.getTime()-date1.getTime())/(24*60*60*1000));
    	    	//如果时间差大于24小时
    	    	if(timeshours>=1){
    	    		//更新登录次数为0
    	    		ausersservice.toinitialloginnum(loginPhone);
    	    		return 11;
    	    	}
            	
            }
        
        
		 return loginCount;
    }
	/**
	 * 新用户注册
	 * @param ausername
	 * @param auserpwd
	 * @return
	 */
	@RequestMapping("toaddusers")
	@ResponseBody
	public String addusers(String userPhone,String userPwd,HttpSession session){
		
		//声明对象变量 判断新用户是否已经注册过
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
