package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.DriverBean;



public interface DriverDAO 
{
	String createDriver(DriverBean driverbean);
	int deleteDriver(ArrayList<String> DriverList) ;
	boolean updateDriver(DriverBean driverbean) ;
	DriverBean findByID(String id) ;
	ArrayList<DriverBean> findAll();
	int generateDriverId();
	boolean setdriverstatus(DriverBean driverBean, String driverid);
}
