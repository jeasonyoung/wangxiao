package com.changh.eschool.entity;

import java.util.Date;
public class Student  implements java.io.Serializable,Cloneable{
	private static final long serialVersionUID = 1L;
	private Integer stuId;
     private Integer id;
     private String stuUsername;
     private String stuPassword;
     private String stuEmail;
     private String stuPhone;
     private String stuMobile;
     private String stuName;
     private String stuSex;
     private String stuAddr;
     private String stuPAddr;
     private String stuPostcal;
     private Date stuAddTime;
     private Date stuLastLoginTime;
     private Integer stuLoginNumber;
     private String stuLoginIp;
     private Integer stuScore;
     private double stuCard;
     private double stuCash;
     private int stuStatus;
     private String stuImgUrl;
     /**
      * qq号
      */
     private String QICQ;
     
	// Constructors
     private String status;
	/** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(Integer stuId, Integer id, String stuUsername, String stuPassword, String stuEmail, Date stuAddTime, Date stuLastLoginTime, Integer stuLoginNumber) {
        this.stuId = stuId;
        this.id = id;
        this.stuUsername = stuUsername;
        this.stuPassword = stuPassword;
        this.stuEmail = stuEmail;
        this.stuAddTime = stuAddTime;
        this.stuLastLoginTime = stuLastLoginTime;
        this.stuLoginNumber = stuLoginNumber;
    }
    
    /** full constructor */
    public Student(Integer stuId, Integer id, String stuUsername, String stuPassword, String stuEmail, String stuPhone, String stuMobile, String stuName, String stuSex, String stuAddr, String stuPAddr, String stuPostcal, Date stuAddTime, Date stuLastLoginTime, Integer stuLoginNumber, String stuLoginIp, Integer stuScore, double stuCard, double stuCash ,int stuStatus) {
        this.stuId = stuId;
        this.id = id;
        this.stuUsername = stuUsername;
        this.stuPassword = stuPassword;
        this.stuEmail = stuEmail;
        this.stuPhone = stuPhone;
        this.stuMobile = stuMobile;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAddr = stuAddr;
        this.stuPAddr = stuPAddr;
        this.stuPostcal = stuPostcal;
        this.stuAddTime = stuAddTime;
        this.stuLastLoginTime = stuLastLoginTime;
        this.stuLoginNumber = stuLoginNumber;
        this.stuLoginIp = stuLoginIp;
        this.stuScore = stuScore;
        this.stuCard = stuCard;
        this.stuCash = stuCash;
        this.stuStatus=stuStatus;
    }

   
    // Property accessors

    public Integer getStuId() {
        return this.stuId;
    }
    
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuUsername() {
        return this.stuUsername;
    }
    
    public void setStuUsername(String stuUsername) {
        this.stuUsername = stuUsername;
    }

    public String getStuPassword() {
        return this.stuPassword;
    }
    
    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuEmail() {
        return this.stuEmail;
    }
    
    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPhone() {
        return this.stuPhone;
    }
    
    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuMobile() {
        return this.stuMobile;
    }
    
    public void setStuMobile(String stuMobile) {
        this.stuMobile = stuMobile;
    }

    public String getStuName() {
        return this.stuName;
    }
    
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return this.stuSex;
    }
    
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAddr() {
        return this.stuAddr;
    }
    
    public void setStuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
    }

    public String getStuPAddr() {
        return this.stuPAddr;
    }
    
    public void setStuPAddr(String stuPAddr) {
        this.stuPAddr = stuPAddr;
    }

    public String getStuPostcal() {
        return this.stuPostcal;
    }
    
    public void setStuPostcal(String stuPostcal) {
        this.stuPostcal = stuPostcal;
    }

    public Date getStuAddTime() {
        return this.stuAddTime;
    }
    
    public void setStuAddTime(Date stuAddTime) {
        this.stuAddTime = stuAddTime;
    }

    public Date getStuLastLoginTime() {
        return this.stuLastLoginTime;
    }
    
    public void setStuLastLoginTime(Date stuLastLoginTime) {
        this.stuLastLoginTime = stuLastLoginTime;
    }

    public Integer getStuLoginNumber() {
        return this.stuLoginNumber;
    }
    
    public void setStuLoginNumber(Integer stuLoginNumber) {
        this.stuLoginNumber = stuLoginNumber;
    }

    public String getStuLoginIp() {
        return this.stuLoginIp;
    }
    
    public void setStuLoginIp(String stuLoginIp) {
        this.stuLoginIp = stuLoginIp;
    }

    public Integer getStuScore() {
        return this.stuScore;
    }
    
    public void setStuScore(Integer stuScore) {
        this.stuScore = stuScore;
    }

    public double getStuCard() {
        return this.stuCard;
    }
    
    public void setStuCard(double stuCard) {
        this.stuCard = stuCard;
    }

    public double getStuCash() {
        return this.stuCash;
    }
    
    public void setStuCash(double stuCash) {
        this.stuCash = stuCash;
    }
    public int getStuStatus() {
  		return stuStatus;
  	}

  	public void setStuStatus(int stuStatus) {
  		this.stuStatus = stuStatus;
  	}
  	
  	public String getStatus() {
		return stuStatus==0?"正常":"冻结";
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public String getStuImgUrl() {
		return stuImgUrl;
	}

	public void setStuImgUrl(String stuImgUrl) {
		this.stuImgUrl = stuImgUrl;
	}
	
	public String getQICQ() {
			return QICQ;
		}

	public void setQICQ(String qICQ) {
			QICQ = qICQ;
	}
}