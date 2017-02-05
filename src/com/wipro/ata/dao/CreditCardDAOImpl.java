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

import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.VehicleBean;

@Repository
@Transactional
public class CreditCardDAOImpl implements CreditCardDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String createCreditCard(CreditCardBean creditCardBean) 
	{
		if(creditCardBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(creditCardBean);
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
	public int deleteCreditCard(ArrayList<String> creditCardList)
	{
		if(creditCardList!=null)
		{
			Iterator<String> itr=creditCardList.iterator();
			while(itr.hasNext())
			{
				try{
					String id=itr.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("delete from CreditCardBean where CreditCardNumber=:ccn");
					query.setParameter("ccn",id);
					query.executeUpdate();
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
	public boolean updateCreditCard(CreditCardBean creditCardBean) 
	{
		if(creditCardBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(creditCardBean);
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
	public CreditCardBean findByID(String id) 
	{
		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			CreditCardBean record=(CreditCardBean) session.get(CreditCardBean.class,id);
			return record;
			
			
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ArrayList<CreditCardBean> findAll()
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("from CreditCardBean");
		ArrayList<CreditCardBean> list=(ArrayList<CreditCardBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public boolean ckeckbalance(float payment) 
	{
		
		
		return false;
	}
	
	
	@Override
	public void updateCreditCardBalance(String creditCardNumber,  Double totalFare) 
	{
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			CreditCardBean creditBean =  (CreditCardBean)session.get(CreditCardBean.class, creditCardNumber);
			System.out.println(creditBean);
			creditBean.setCreditBalance(creditBean.getCreditBalance()-totalFare);
			System.out.println(creditBean.getCreditBalance());
			session.saveOrUpdate(creditBean);
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
