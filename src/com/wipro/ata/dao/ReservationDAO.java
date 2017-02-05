package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.ReservationBean;

public interface ReservationDAO 
{
	String createReservation(ReservationBean reservationbean);
	int deleteReservation(ArrayList<String> reservationList) ;
	boolean updateReservation(ReservationBean reservationbean) ;
	ReservationBean findByID(String id) ;
	ArrayList<ReservationBean> findAll();
	String generateReservationId();
	String findRouteID(String s1, String s2);
	String findVehicleID(String s3,int s4);
    String findUserId();
    String findDriverId();
    int findtotalkm(String routeID);
    double findfareperkm(String vehicleId);
    // String UserIdfromReservationID(String reservationID);
}
