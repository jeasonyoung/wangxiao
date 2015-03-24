package com.changh.eschool.entity;

import java.util.Date;
import com.changh.eschool.until.TimeFormat;
/**
 * StudyCard entity. @author MyEclipse Persistence Tools
 */
public class StudyCard  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cardId;
     private Integer id;
     private String cardPassword;
     private Integer cardValue;
     private Date cardAddTime;
     private Date cardOverTime;
     private long stuId;
     private Date cardUseTime;
     private Integer cardIsPresent; //是否赠送 0：不送，1：送
     private double cardBalance;
     private String cardNo;
     //
     private String present;
    // Constructors
    /** default constructor */
    public StudyCard() {
    }
	/** minimal constructor */
    public StudyCard(Integer cardId, Integer id, String cardPassword, Integer cardValue, Date cardAddTime, Date cardOverTime) {
        this.cardId = cardId;
        this.id = id;
        this.cardPassword = cardPassword;
        this.cardValue = cardValue;
        this.cardAddTime = cardAddTime;
        this.cardOverTime = cardOverTime;
    }
    /** full constructor */
    public StudyCard(Integer cardId, Integer id, String cardPassword, Integer cardValue, Date cardAddTime, Date cardOverTime, long stuId, Date cardUseTime, Integer cardIsPresent) {
        this.cardId = cardId;
        this.id = id;
        this.cardPassword = cardPassword;
        this.cardValue = cardValue;
        this.cardAddTime = cardAddTime;
        this.cardOverTime = cardOverTime;
        this.stuId = stuId;
        this.cardUseTime = cardUseTime;
        this.cardIsPresent = cardIsPresent;
    }
    // Property accessors
    public Integer getCardId() {
        return this.cardId;
    }
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardPassword() {
        return this.cardPassword;
    }
    
    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public Integer getCardValue() {
        return this.cardValue;
    }
    
    public void setCardValue(Integer cardValue) {
        this.cardValue = cardValue;
    }

    public Date getCardAddTime() {
        return this.cardAddTime;
    }
    
    public void setCardAddTime(Date cardAddTime) {
        this.cardAddTime = cardAddTime;
    }

    public Date getCardOverTime() {
        return this.cardOverTime;
    }
    
    public void setCardOverTime(Date cardOverTime) {
        this.cardOverTime = cardOverTime;
    }

    public long getStuId() {
        return this.stuId;
    }
    
    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public Date getCardUseTime() {
        return this.cardUseTime;
    }
    
    public void setCardUseTime(Date cardUseTime) {
        this.cardUseTime = cardUseTime;
    }

    public Integer getCardIsPresent() {
        return this.cardIsPresent;
    }
    
    public void setCardIsPresent(Integer cardIsPresent) {
        this.cardIsPresent = cardIsPresent;
    }
   
    public String getPresent()
    {
    	return cardIsPresent==0?"否":"是";
    }

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getCardNo() {
		String time = TimeFormat.format(cardAddTime).substring(0, 6);
		if(cardIsPresent==1)
		return "wx"+time+"mf"+cardId;
		return "wx"+time+"sf"+cardId;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}