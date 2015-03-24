package com.changh.eschool.entity;

import java.util.Date;
/**
 * StudyRecord entity. @author MyEclipse Persistence Tools
 */
public class StudyRecord implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer recordId;
	private Integer stuId;
	private Integer id;
	private Integer classId;
	private Date recordStartTime;
	private String recordIp;
	private Integer gradeId;
	private String recordName;
	private Integer countNum;
	
	public StudyRecord() {
	}
	
	/** full constructor */
	public StudyRecord(Integer recordId, Integer id,
			Integer classId, Date recordStartTime, String recordIp,
			Integer gradeId) {
		this.recordId = recordId;
		this.id = id;
		this.classId = classId;
		this.recordStartTime = recordStartTime;
		this.recordIp = recordIp;
		this.gradeId = gradeId;
	}
	
	public Integer getRecordId() {
		return this.recordId;
	}
	
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getClassId() {
		return this.classId;
	}
	
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	public Date getRecordStartTime() {
		return this.recordStartTime;
	}
	
	public void setRecordStartTime(Date recordStartTime) {
		this.recordStartTime = recordStartTime;
	}
	
	public String getRecordIp() {
		return this.recordIp;
	}
	
	public void setRecordIp(String recordIp) {
		this.recordIp = recordIp;
	}
	
	public Integer getGradeId() {
		return this.gradeId;
	}
	
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	public Integer getStuId() {
		return stuId;
	}
	
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	
	public String getRecordName() {
		return recordName;
	}
	
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	
	public Integer getCountNum() {
		return countNum;
	}
	
	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}
}