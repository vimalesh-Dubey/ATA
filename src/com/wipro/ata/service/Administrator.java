package com.wipro.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;

public interface Administrator 
{
	String addVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> vehicleID);
	ArrayList<VehicleBean> viewVehicle();
	boolean modifyVehicle(VehicleBean vehicleBean);
	String addDriver(DriverBean driverBean);
	int deleteDriver(ArrayList<String> driverID);
	boolean allotDriver(String reservationID, String driverID);
	boolean modifyDriver(DriverBean driverBean);
	String addRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String> routeID) ;
	ArrayList<RouteBean> viewRoute();
	boolean modifyRoute(RouteBean routeBean);
	ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
	ArrayList<DriverBean> viewDriver();

}
