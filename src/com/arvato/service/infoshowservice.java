package com.arvato.service;

import java.util.List;

import com.arvato.po.infoshow;

public interface infoshowservice {
	public List<infoshow> toSearch();
	public int toDeleteTitle(int infoNo);
	public infoshow toSearchContext(int infoNo);
	public void toEdit(int infoNo,String infoTitle);

}
