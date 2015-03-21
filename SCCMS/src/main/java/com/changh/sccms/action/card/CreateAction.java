package com.changh.sccms.action.card;

import java.util.Date;

import com.changh.sccms.service.StudyCardService;

public class CreateAction {
	//input
	private int num;		//创建数量
	private int pwdNum;		//密码长度
	private int value;		//面值
	private int isPresent;	//是否赠送
	private int month;		//有效期限
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPwdNum() {
		return pwdNum;
	}
	public void setPwdNum(int pwdNum) {
		this.pwdNum = pwdNum;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIsPresent() {
		return isPresent;
	}
	public void setIsPresent(int isPresent) {
		this.isPresent = isPresent;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	//injection
	private StudyCardService studyCardService;
	
	public void setStudyCardService(StudyCardService studyCardService) {
		this.studyCardService = studyCardService;
	}
	public String execute()throws Exception
	{
		studyCardService.createCards(num, value, month, pwdNum, isPresent);
		return "success";
	}
}
