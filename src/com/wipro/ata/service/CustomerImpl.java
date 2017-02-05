package com.wipro.ata.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.CredentialsDAO;
import com.wipro.ata.dao.CreditCardDAO;
import com.wipro.ata.dao.DriverDAO;
import com.wipro.ata.dao.ReservationDAO;
import com.wipro.ata.dao.RouteDAO;
import com.wipro.ata.dao.VehicleDAO;




@Service
@Transactional
public class CustomerImpl implements Customer {
	
	@Autowired
	private VehicleDAO vehicleDAO;
	@Autowired
    private ReservationDAO reservationDAO;
	@Autowired
	private CredentialsDAO credentialsDAO;
    @Autowired
    private DriverDAO driverDAO;
    @Autowired
    private RouteDAO routeDAO;
    @Autowired
    private CreditCardDAO creditCardDAO;
    
    
	public VehicleDAO getVehicleDAO() {
		return vehicleDAO;
	}

	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	public ReservationDAO getReservationDAO() {
		return reservationDAO;
	}

	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}

	public RouteDAO getRouteDAO() {
		return routeDAO;
	}

	public void setRouteDAO(RouteDAO routeDAO) {
		this.routeDAO = routeDAO;
	}

	
	
    
    @Override
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) {
		
		if (vehicleType == null || vehicleType.equals("")) 
		{
			return null;
		} 
		else 
		{
			ArrayList<VehicleBean> result = vehicleDAO.findAll(vehicleType);

						return result;
		}
	}

	@Override
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) 
	{
		if(noOfSeats==0)
		{
			return null;
		}
		else
		{
			ArrayList<VehicleBean> result=vehicleDAO.findAll(noOfSeats);
			return result;
		}

	}

	@Override
	public ArrayList<RouteBean> viewAllRoutes() 
	{
		ArrayList<RouteBean> routeBean=routeDAO.findAll();
		return routeBean;
	}

	
	//===========================METHOD for booking  vehicles=============================
	@Override
	public String bookVehicle(ReservationBean reservationBean) 
	{
		if(reservationBean==null)
		{
			return "FAIL";
		}
		else
		{
			String boardingpoint=reservationBean.getBoardingPoint();
			String droppoint=reservationBean.getDropPoint();
			String vehicletype=reservationBean.getVehicleBean().getType();
			System.out.println(vehicletype);
			int seatsrequired=reservationBean.getVehicleBean().getSeatingCapacity();
			
			System.out.println("seat_req."+seatsrequired);
			Date bdate=reservationBean.getBookingDate();
			String vehicleID= reservationDAO.findVehicleID(vehicletype,seatsrequired);
			System.out.println("vid"+vehicleID);
			//call a method
			
			int totalseats=vehicleDAO.getTotalSeats(vehicleID);
			System.out.println("TOTAL SEATS"+totalseats);
			System.out.println("required_seats"+seatsrequired);
			if(seatsrequired>totalseats)
			{
				
				return "INVALID_NO_OF_SEATS";
				
				
			}
			String routeID=reservationDAO.findRouteID(boardingpoint, droppoint);
			if(routeID==null)
			{
				return "ROUTE_DOES_NOT_EXIST";
			}
			String rid = reservationDAO.generateReservationId();
			String userid=reservationDAO.findUserId();                                                                                                            
			String driverid=reservationDAO.findDriverId();
			if(driverid==null)
			{
				
				return "NO_DRIVER_AVAILABLE";
			}
			
			double distance=reservationDAO.findtotalkm(routeID);
			System.out.println("distance"+distance);
			double fare=reservationDAO.findfareperkm(vehicleID);
			System.out.println("fare is"+fare);
			
			double totalfare=fare*distance;
			Date dateobj=new Date();
			reservationBean.setBookingDate(dateobj);
			reservationBean.setBookingStatus("yes");
			reservationBean.setReservationID(rid+"");
			System.out.println("fare*distance:"+totalfare);
			reservationBean.setTotalFare(totalfare);
			
			RouteBean routebean=routeDAO.findByID(routeID);
			System.out.println("route_bean:"+routebean);
			reservationBean.setRouteBean(routebean);
			CredentialsBean credbean=credentialsDAO.findByID(userid);
		    reservationBean.setCredentialsBean(credbean);
			DriverBean driverbean=driverDAO.findByID(driverid);
			reservationBean.setDriverBean(driverbean);
			VehicleBean vehbean=vehicleDAO.findByID(vehicleID);
			
			reservationBean.setVehicleBean(vehbean);
           
			String str=reservationDAO.createReservation(reservationBean);
			if(str.equals("SUCCESS"))
			{
		  		int remainingseats=totalseats-seatsrequired;
				
				
				VehicleBean bean=vehicleDAO.findByID(vehicleID);
				bean.setSeatingCapacity(remainingseats);               //updating number of seats
				vehicleDAO.updateVehicle(bean);
				
				driverDAO.setdriverstatus(reservationBean.getDriverBean(),driverid);//changing the driver status
			}
			return str;	
		}
	}

	
	//=====================method for cancel booking===========================
	@Override
	public boolean cancelBooking(String userID, String reservationID) 
	{
		
		ArrayList<String> test=new ArrayList<String>();
		test.add(reservationID);
		int result=reservationDAO.deleteReservation(test);
		if(result==1)
		{
			return true;
		}
		return false;
	}

	
	//================================method for view booking details==========================
	@Override
	public ReservationBean viewBookingDetails(String reservationID) {
		if(reservationID==null || reservationID.equals(""))
		{
			return null;
		}
		else
		{
			ReservationBean reservationBean=reservationDAO.findByID(reservationID);
			return reservationBean;
		}
	}

	
	//=============================print booking details=====================
	@Override
	public ReservationBean printBookingDetails(String reservationID) {
		if(reservationID==null || reservationID.equals(""))
		{
			return null;
		}
		else
		{
			ReservationBean reservationBean=reservationDAO.findByID(reservationID);
			return reservationBean;
		}
	}

	@Override
	public CreditCardBean validateCard(String creditCardNumber) 
	{
		CreditCardBean creditcard  = creditCardDAO.findByID(creditCardNumber);
		if(creditcard!=null)
		{
			return creditcard;
		}
		else
			return null;
	}

	@Override
	public boolean checkBalance(float payment) 
	{
		creditCardDAO.ckeckbalance(payment);
		
		return false;
	}

	@Override
	public void payMoney(String creditCardNumber, Double totalFare) 
	{
		
		creditCardDAO.updateCreditCardBalance(creditCardNumber,totalFare);
		
	}
}
