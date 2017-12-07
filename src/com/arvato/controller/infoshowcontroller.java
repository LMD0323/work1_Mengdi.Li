package com.arvato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arvato.po.infoshow;
import com.arvato.service.infoshowservice;


@Controller
public class infoshowcontroller {
	@Autowired
	infoshowservice showservice;
	
	@RequestMapping("showinfo")
	public String showinfo(Model model){
		List<infoshow> showlist=showservice.toSearch();
		model.addAttribute("showlist", showlist);
		return "list";
	}
	@RequestMapping("deletetitle")
	public String deletetitle(int infoNo){
		int count = showservice.toDeleteTitle(infoNo);
		if(count>0){
			return "forward:showinfo.action";
		}
		return "forward:showinfo.action";
	}
	@RequestMapping("searchcontext")
	public String searchContext(int infoNo,Model model){
		infoshow infoshow=showservice.toSearchContext(infoNo);
		model.addAttribute("infoshow", infoshow);
		return "context";
	}
	@RequestMapping("edit")
	@ResponseBody
	public String edit(int infoNo,String infoTitle ){
		showservice.toEdit(infoNo, infoTitle);
		return "ok";
	}

}
