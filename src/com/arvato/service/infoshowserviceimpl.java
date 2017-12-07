package com.arvato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvato.mapper.infoshowMapper;
import com.arvato.po.infoshow;

@Service
public class infoshowserviceimpl implements infoshowservice {
    
	@Autowired
	infoshowMapper infoshowmapper;
	public List<infoshow> toSearch() {
		// TODO Auto-generated method stub
		List<infoshow> listshow = infoshowmapper.toSearch();
		return listshow;
	}
	public int toDeleteTitle(int infoNo) {
		int count = infoshowmapper.toDeleteTitle(infoNo);
		return count;
	}
	public infoshow toSearchContext(int infoNo) {
		// TODO Auto-generated method stub
		infoshow infoshow = infoshowmapper.toSearchContext(infoNo);
		 return infoshow;
	}
	public void toEdit(int infoNo, String infoTitle) {
		// TODO Auto-generated method stub
		String infoNo1= infoNo+"";
		infoshowmapper.toEdit(infoNo1, infoTitle);
		
	}

}
