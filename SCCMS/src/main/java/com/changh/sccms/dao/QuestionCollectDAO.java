package com.changh.sccms.dao;

import java.util.List;

import com.changh.sccms.entity.QuestionCollect;

public interface QuestionCollectDAO {
	public List<QuestionCollect> findByStuId(int stuId)throws Exception;
	//收藏存到库
	public void save(QuestionCollect qc)throws Exception;
	//删除
	public void delete(QuestionCollect qc)throws Exception;
}
