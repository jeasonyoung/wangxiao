package com.changh.eschool.service;

import java.util.List;

import com.changh.eschool.entity.RechargeRecord;
import com.changh.eschool.entity.StudyCard;
import com.changh.eschool.entity.Trade;


public interface StudyCardService {
	//学习卡充值
	public int recharge(int cardId,String password,int money)throws Exception;
	//充值记录
	public List<RechargeRecord> findRecordByStuId(int stuId,int page,int pagesize,String sortname,String sortorder)throws Exception;
	public long findTotalByStuId(int stuId)throws Exception;
	public List<Trade> findTradeByStuId(int stuId,int page,int pagesize,String sortname,String sortorder)throws Exception;
	public long findTradeTotalByStuId(int stuId)throws Exception;
	//学习卡余额查询
	public StudyCard findCard(int cardId,String password)throws Exception;
}
