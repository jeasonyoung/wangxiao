package com.changh.sccms.action.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.changh.sccms.entity.StudyCard;
import com.changh.sccms.service.StudyCardService;
import com.changh.sccms.until.GridDataUtil;

public class SearchAction {
	private String str;
	private String searchName;
	private StudyCardService studyCardService;
	private Map<String,Object> cardList;
	
	public Map<String, Object> getCardList() {
		return cardList;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public void setStudyCardService(StudyCardService studyCardService) {
		this.studyCardService = studyCardService;
	}
	public String execute()throws Exception
	{
		StudyCard card = studyCardService.findById(Integer.parseInt(str.substring(str.indexOf("f")+1)));
		List<StudyCard> list = new ArrayList<StudyCard>();
		list.add(card);
		cardList = GridDataUtil.gridMap(list, list.size());
		return "success";
	}
}
