package com.wipro.ata.dao;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.ProfileBean;

@Repository
@Transactional
public class ProfileBeanDAOImpl implements ProfileBeanDAO 
{
	 private Iterator<Integer> iter;
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String createProfileBean(ProfileBean pb) 
	{
		if(pb!=null)
		{
			try
			{
				Session s=sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				s.save(pb);
				t.commit();
				s.close();
		
		
				return "SUCCESS";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "FAIL";
			}
		}
		else
		{
			return "FAIL";
		}
	}
	@Override
	public int deleteProfileBean(ArrayList<String> a) 
	{
		
		if(a!=null)
		{
			Iterator<String> i=a.iterator();
			while(i.hasNext())
			{
				try{
					String id=i.next();
					Session s=sessionFactory.openSession();
					Transaction t=s.beginTransaction();
					Query q=s.createQuery("delete from ATA_TBL_USER_PROFILE where userID=:a");
					q.setParameter("a",id);
					q.executeUpdate();
					t.commit();
					s.close();
				
					}
				catch(Exception e)
				{
					e.printStackTrace();
					return 0;
				}
			}
			return 1;
		}
		else
		{
			return 0;
		}
		
		
	}

	@Override
	public boolean updateProfileBean(ProfileBean pb) 
	{
		if(pb!=null)
		{
			try
			{
				Session s=sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				ProfileBean pb2=(ProfileBean) s.get(ProfileBean.class,pb.getUserId());
				pb2.setPassword(pb.getPassword());
				s.saveOrUpdate(pb2);
				t.commit();
				s.close();
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return false;	
		}
		
	}

	@Override
	public ProfileBean findByID(String id) 
	{
		
		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			ProfileBean record=(ProfileBean) session.get(ProfileBean.class,id);
			return record;
			/*Transaction tx=session.beginTransaction();
			Query q=session.createQuery("select * from ATA_TBL_USER_PROFILE where userID=:a ");
			q.setParameter("a",id);
			*/
			
		}
		else
		{
		return null;
		}
	}

	@Override
	public ArrayList<ProfileBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from ATA_TBL_USER_PROFILE");
		ArrayList<ProfileBean> list=(ArrayList<ProfileBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int generateUserId() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("select ata_seq_userId.nextval from dual");
		List<BigDecimal> l=q.list();
		
		BigDecimal id = l.get(0);
		
		tx.commit();
		session.close();
		return id.intValue();
		
         
	
}
}