package com.changh.sccms.action.grade;

import com.changh.sccms.entity.Grade;
import com.changh.sccms.service.ExamCategoryService;
import com.changh.sccms.service.GradeService;
import com.changh.sccms.service.TeacherService;

public class UpdateAction {
	private boolean ok =false;
	private Grade grade;
	private GradeService gradeService;
	public String execute() throws Exception{
		
		gradeService.update(grade);
		setOk(true);
		return "success";
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public GradeService getGradeService() {
		return gradeService;
	}
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
