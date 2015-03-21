package com.changh.sccms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.changh.sccms.dao.ExamQuestionDAO;

public class Test1 {
	public  void Test2() throws Exception{
		String[] configs = {"applicationContext-base.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(configs);
		ExamQuestionDAO dao = (ExamQuestionDAO) ac.getBean("examQuestionDao");
//		Teacher teacher = new Teacher();
//		teacher.setTchAddTime(new Date());
//		teacher.setTchStatus(1);
//		teacher.setTchName("老师");
//		teacher.setTchPassword("111111");
//		teacher.setTchUsername("test113");
//		dao.save(teacher);
		//System.out.println(dao.search(1, 10, "tchAddTime", "desc", "2", "tchId").size());
		//System.out.println(dao.findAll(1, 10, "tchAddTime", "desc").size());
		//System.out.println(dao.search("1", "tchId").size());
		dao.deleteAll("(1048,1049)");
	}
}
