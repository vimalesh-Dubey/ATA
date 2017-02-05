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

import com.sun.org.apache.xml.internal.utils.IntVector;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.VehicleBean;

import antlr.collections.List;


@Repository
@Transactional
public class ReservationDAOImpl implements ReservationDAO
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
	public String createReservation(ReservationBean reservationbean)
	{
		if(reservationbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(reservationbean);
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
	public int deleteReservation(ArrayList<String> reservationList) 
	{
		if(reservationList!=null)
		{
			Iterator<String> itr=reservationList.iterator();
			while(itr.hasNext())
			{
				try{
					String id=itr.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("delete from ReservationBean where reservationID=:resId");
					query.setParameter("resId",id);
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
	public boolean updateReservation(ReservationBean reservationbean)
	{
		if(reservationbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(reservationbean);
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
	public ReservationBean findByID(String id) 
	{

		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			ReservationBean record=(ReservationBean) session.get(ReservationBean.class,id);
			return record;
			
			
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ArrayList<ReservationBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from ReservationBean");
		ArrayList<ReservationBean> list=(ArrayList<ReservationBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String generateReservationId() 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("select ata_seq_reservationId.nextval from dual");
		return (q.uniqueResult().toString());
	}

	@Override
	public String findVehicleID(String s3, int s4) {
		if(s3!=null||s4!=0){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select reservation.vehicleID from VehicleBean reservation where reservation.type=:vtype and reservation.seatingCapacity=:noOfSeats ");
		query.setString("vtype", s3);
		query.setInteger("noOfSeats", s4);
		//java.util.List vid= query.list();
		   Iterator it=query.iterate();
		while(it.hasNext()){
			String vehicleid= (String) it.next();
			System.out.println("vehicle id"+vehicleid);
			return vehicleid;
		}}
		return null;
				
	}

	@Override
	public String findRouteID(String s1, String s2) {
		if(s1!=null||s2!=null){
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("select reservation.routeID from RouteBean reservation where reservation.source=:source and reservation.destination=:destination ");
			query.setString("source", s1);
			query.setString("destination", s2);
			java.util.List vid= query.list();
			   Iterator<String> it=vid.iterator();
			while(it.hasNext()){
				String routeid= it.next();
				return routeid;
			}}
			return null;
	}

	@Override
	public String findUserId() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select reservation.userID from CredentialsBean reservation where reservation.loginStatus=:Status");
		query.setInteger("Status", 1);
		//java.util.List<String> list=query.list();
		//Iterator<String> it=list.iterator();
		Iterator it=query.iterate();
		while(it.hasNext()){
			String userid=(String) it.next();
			return userid;
		}
		return null;
	}
	
 public String findDriverId()
 {
	 Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select r.driverID from DriverBean r where r.Status=:status");
		query.setString("status","available" );
		//java.util.List<DriverBean> list=query.list();
		//Iterator<DriverBean> it=list.iterator();
	Iterator it=query.iterate();
		while(it.hasNext())
		{
			
		/*	if(driverbean.getStatus().equals("alloted"))
			{
				continue;
				
			}
			else
			{
				return driverbean.getDriverID();
			}*/
			
			return (String) it.next();
			
			
		}
		return null;
 }
 
 public int findtotalkm(String routeid)
 {
	 Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(" select reservation.distance from RouteBean reservation where reservation.routeID=:routeid");
		query.setString("routeid", routeid+"");
		java.util.List<Integer> list=query.list();
		Iterator<Integer> it=list.iterator();
		while(it.hasNext())
		{
			return it.next();
		}
		return 0;
	 
	 
	 
 }
 
 
 public double findfareperkm(String vehicleId)
 {
	 Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select reservation.farePerKM from VehicleBean reservation where reservation.vehicleID=:vehicleId");
		query.setString("vehicleId",vehicleId+"");
		java.util.List<Double> list=query.list();
		Iterator<Double> it=list.iterator();
		while(it.hasNext())
		{
			return it.next();
		}
		
		
		
		return 0;
	 
	 
	 
	
	 
 }
 
 
/* public String UserIdfromReservationID(String reservationID)
 {
	 Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select r.userID from ReservationBean r where r.reservationID=:resid");
		query.setString("resid",reservationID);
		Iterator it=query.iterate();
		while(it.hasNext())
		{
			return (String) it.next();
		}
		return null;
	 
	 
	
	 
 }*/
}
