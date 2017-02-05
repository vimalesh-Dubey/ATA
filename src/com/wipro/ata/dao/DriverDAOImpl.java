package com.wipro.ata.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.DriverBean;


@Repository
@Transactional
public class DriverDAOImpl implements DriverDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//=============================================implement methods===========================
	@Override
	public String createDriver(DriverBean driverbean) 
	{
		if(driverbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(driverbean);
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
	public int deleteDriver(ArrayList<String> DriverList) 
	{
		if(DriverList!=null)
		{
			Iterator<String> i=DriverList.iterator();
			while(i.hasNext())
			{
				try{
					String id=i.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query q=session.createQuery("delete from DriverBean where driverID=:a");
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
	public boolean updateDriver(DriverBean driverbean) 
	{
		if(driverbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(driverbean);
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
	public DriverBean findByID(String id) 
	{
		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			DriverBean record=(DriverBean) session.get(DriverBean.class,id);
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
	public ArrayList<DriverBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from DriverBean");
		ArrayList<DriverBean> list= (ArrayList<DriverBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public  boolean setdriverstatus(DriverBean bean,String driverid) 
	{
		bean.setStatus("Unavailable");
		
				return updateDriver(bean);
		 
	}


	@Override
	public int generateDriverId() 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("select ata_seq_driverId.nextval from dual");
		return (Integer.parseInt(q.uniqueResult().toString()));
	}
	

}
