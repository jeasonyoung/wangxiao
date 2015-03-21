package com.changh.sccms.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.changh.sccms.dao.NewsDAO;
import com.changh.sccms.entity.News;
import com.changh.sccms.entity.Province;

public class HibernateNewsDAO  extends HibernateDaoSupport implements NewsDAO {

	public List<News> findAll(final Integer newsClassId ,final Integer provinceId,final int page, final int pagesize, final String sortname,
			final String sortorder) throws Exception {
		// TODO Auto-generated method stub
		return (List)this.getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
					{
						//使用session执行分页查询代码
						StringBuffer hql= new StringBuffer();
						hql.append("from News n where 1=1");
						if(0!=newsClassId){
							hql.append(" and ( n.exam.examId ="+newsClassId+" or n.exam.parentsId like '%"+newsClassId+"%')");
						}
						if(0!=provinceId){
							hql.append(" and n.province.provinceId="+provinceId);
						}
						hql.append(" order by "+sortname+" "+sortorder);
						Query query=session.createQuery(hql.toString());
						query.setFirstResult((page-1)*pagesize);
						query.setMaxResults(pagesize);
						return query.list();
					}
				}
			);
	}
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(News.class, id));
		return true;
		
	}

	@Override
	public boolean saveOrupdate(News news) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(news);
		return true;
	}

	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		return (News) this.getHibernateTemplate().get(News.class, id);
	}
	
	
	public List<News> findListNews(final int page, final int pagesize,
			final String sortname, final String sortorder,final HashMap<String ,Object> map) {
		// TODO Auto-generated method stub
		return (List)this.getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
					{
						//使用session执行分页查询代码
						//String hql="from News where 1=1 and n  order by "+sortname+" "+sortorder;
						StringBuffer hql = new StringBuffer();
						hql.append("from News n where 1=1");
						if(map!=null&&map.size()!=0){
							 Iterator it = map.entrySet().iterator();   
							  while (it.hasNext()) {     
							        Map.Entry entry = (Map.Entry) it.next();   
							        String key = (String) entry.getKey();   
							        Object value = entry.getValue();   
							        hql.append("and n."+key+"="+value);
							}  
						}
						hql.append(" order by "+sortname+" "+sortorder);
						Query query=session.createQuery(hql.toString());
						query.setFirstResult((page-1)*pagesize);
						query.setMaxResults(pagesize);
						return query.list();
					}
				}
			);
	}

	@Override
	public int getTotal(Integer newsClassId ,Integer provinceId,Integer examId) {
		StringBuffer hql= new StringBuffer();
		hql.append("select count(*) from News n where 1=1");
		if(0!=newsClassId){
			hql.append(" and n.newclass.id ="+newsClassId);
		}
		if(0!=provinceId){
			hql.append(" and n.province.provinceId="+provinceId);
		}
		if(0!=examId){
			hql.append(" and ( n.exam.examId ="+examId+"  or n.exam.parentsId like '%"+examId+"%')");
		}
		// TODO Auto-generated method stub
		 return ((Long)getHibernateTemplate().iterate(hql.toString()).next()).intValue(); 
	}

	@Override
	public List<Province> findByPro(String pro, Object value) {
		return 	this.getHibernateTemplate().find("from  Province p where  p."+pro+" = ?", value);
	}
	

}
