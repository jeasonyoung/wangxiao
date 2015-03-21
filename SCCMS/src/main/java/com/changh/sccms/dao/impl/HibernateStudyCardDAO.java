package com.changh.sccms.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.changh.sccms.dao.StudyCardDAO;
import com.changh.sccms.entity.Student;
import com.changh.sccms.entity.StudyCard;

public class HibernateStudyCardDAO extends HibernateDaoSupport implements StudyCardDAO {
	//批量生成学习卡
	public void createCards(final List<StudyCard> list) throws Exception {
		this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int count=0;
				for(int i=0;i<list.size();i++)
				{
					session.save(list.get(i));
					count++;
					if(count%20==0)
					{
						session.flush();
						session.clear();//不让hibernate缓存太多对象，没必要
					}
				}
				session.flush();
				session.clear();
				return null;
			}
			
		});
	}
	//find all
	public List<StudyCard> findAll() throws Exception {
		String hql = "from StudyCard";
		return this.getHibernateTemplate().find(hql);
	}
	//找出一定日期后生成的所有
	public List<StudyCard> findAll(Date date) throws Exception {
		String hql="from StudyCard s where s.cardAddTime > ? ";
		Object[] params=new Object[]{date};
		return this.getHibernateTemplate().find(hql, params);
	}
	//
	public List<StudyCard> findTopN(final int num) throws Exception {
		return (List)this.getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
					{
						//使用session执行分页查询代码
						String hql="from StudyCard where cardUseTime is null order by cardAddTime desc";
						Query query=session.createQuery(hql);
						query.setFirstResult(0);
						query.setMaxResults(num);
						return query.list();
					}
				}
			);
	}
	public List<StudyCard> findTopN(int num,final int page,final int pagesize,
			String sortName, String sortorder) {
		return (List)this.getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
					{
						//使用session执行分页查询代码
						String hql="from StudyCard where cardUseTime is null order by cardAddTime asc";
						Query query=session.createQuery(hql);
						query.setFirstResult((page-1)*pagesize);
						query.setMaxResults(pagesize);
						return query.list();
					}
				}
			);
	}
	//分页查询
		public List<StudyCard> findPage(final int page,final int pagesize,final String sortName,final String sortorder)
		{
			return (List)this.getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
					{
						//使用session执行分页查询代码
						String hql="from StudyCard order by "+sortName+" "+sortorder;
						Query query=session.createQuery(hql);
						query.setFirstResult((page-1)*pagesize);
						query.setMaxResults(pagesize);
						return query.list();
					}
				}
			);
		}
		public long findTotal() throws Exception {
			String hql = "select count(*) from StudyCard";
			return (Long) this.getHibernateTemplate().find(hql).get(0);
					
		}
		public StudyCard findById(int cardId) throws Exception {

			return (StudyCard) this.getHibernateTemplate().get(StudyCard.class, cardId);
		}
}
