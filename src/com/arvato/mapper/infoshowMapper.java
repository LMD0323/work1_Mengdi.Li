package com.arvato.mapper;

import java.util.List;

import com.arvato.po.infoshow;

public interface infoshowMapper {
	//��ʾ��Ϣ�б�
	public List<infoshow> toSearch();
	//ɾ������
	public int toDeleteTitle(int infoNo);
	//�ܾݱ����ѯ����
	public infoshow toSearchContext(int infoNo);
	//�༭����
	public void toEdit(String infoNo,String infoTitle);

}
