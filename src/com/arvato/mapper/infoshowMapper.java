package com.arvato.mapper;

import java.util.List;

import com.arvato.po.infoshow;

public interface infoshowMapper {
	//显示消息列表
	public List<infoshow> toSearch();
	//删除标题
	public int toDeleteTitle(int infoNo);
	//很据标题查询内容
	public infoshow toSearchContext(int infoNo);
	//编辑内容
	public void toEdit(String infoNo,String infoTitle);

}
