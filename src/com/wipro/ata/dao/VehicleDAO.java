package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.VehicleBean;

public interface VehicleDAO 
{
	String createVehicle( VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> VehicleList) ;
	boolean updateVehicle(VehicleBean VehicleBean) ;
	VehicleBean findByID(String id) ;
	ArrayList<VehicleBean> findAll();
	public ArrayList<VehicleBean> findAll(int noOfSeats) ;
	public ArrayList<VehicleBean> findAll(String bustype);
	int generateVehicleId();
	int getTotalSeats(String vehicleID);

}
