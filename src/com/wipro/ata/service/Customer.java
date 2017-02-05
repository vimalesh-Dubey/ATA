package com.wipro.ata.service;

import java.util.ArrayList;

import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;

public interface Customer 
{
	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
	ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
	ArrayList<RouteBean> viewAllRoutes();
	String bookVehicle(ReservationBean reservationBean);
	boolean cancelBooking(String userID, String reservationID);
	ReservationBean viewBookingDetails(String reservationID);
	ReservationBean printBookingDetails(String reservationID);
	CreditCardBean validateCard(String creditCardNumber);
	boolean checkBalance(float balance);
	void payMoney(String creditCardNumber, Double totalFare);

}
