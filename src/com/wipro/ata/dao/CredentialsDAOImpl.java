package com.wipro.ata.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;


@Repository
@Transactional
public class CredentialsDAOImpl implements CredentialsDAO
{
	@Autowired
	private SessionFactory  sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
//==============================================================================================================
	
	//defining  implemented methdos
//=======================================================================================================
	@Override
	public String createCredentials(CredentialsBean credentialsBean)
	{
		if(credentialsBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(credentialsBean);
				tx.commit();
				session.close();
		
		
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
	public int deleteCredentials(ArrayList<String> CredentialsList) 
	{
		if(CredentialsList!=null)
		{
			Iterator<String> i=CredentialsList.iterator();
			while(i.hasNext())
			{
				try{
					String id=i.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query q=session.createQuery("delete from CredentialsBean where userID=:a");
					q.setParameter("a",id);
					q.executeUpdate();
					tx.commit();
					session.close();
				
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
	public boolean updateCredentials(CredentialsBean credentialsBean) 
	{
		if(credentialsBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				CredentialsBean cb=(CredentialsBean) session.get(CredentialsBean.class,credentialsBean.getUserID());
				cb.setPassword(credentialsBean.getPassword());
				session.saveOrUpdate(cb);
				tx.commit();
				session.close();
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
	public CredentialsBean findByID(String id)
	{
		if(id!=null)
		{
			System.out.println(id);
			Session session=sessionFactory.openSession();
			CredentialsBean record=(CredentialsBean) session.get(CredentialsBean.class,id);
			System.out.println(record);
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
	public ArrayList<CredentialsBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from CredentialsBean");
		ArrayList<CredentialsBean> list= (ArrayList<CredentialsBean>) q.list();
		return list;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}

}}
