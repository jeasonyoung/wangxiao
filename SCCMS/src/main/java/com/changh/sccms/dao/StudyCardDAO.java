package com.changh.sccms.dao;

import java.util.Date;
import java.util.List;

import com.changh.sccms.entity.StudyCard;

public interface StudyCardDAO {
	//批量插入
	public void createCards(List<StudyCard> list)throws Exception;
	//找出所有的记录
	public List<StudyCard> findAll()throws Exception;
	//找出date之后生成的所有记录
	public List<StudyCard> findAll(Date date)throws Exception;
	//找出最近生成的N个
	public List<StudyCard> findTopN(int num)throws  Exception;
	//找出记录的总个数
	public long findTotal()throws Exception;
	//分页查询
	public List<StudyCard> findPage(int page,int pagesize,String sortName,String sortorder)throws Exception;
	public List<StudyCard> findTopN(int num, int page, int pagesize,
			String sortName, String sortorder);
	//find by id
	public StudyCard findById(int cardId)throws Exception;
}
