package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.RouteBean;


public interface RouteDAO 
{
	String createRoute( RouteBean routeBean);
	int deleteRoute(ArrayList<String> RouteList) ;
	boolean updateRoute(RouteBean routeBean) ;
	RouteBean findByID(String id) ;
	ArrayList<RouteBean> findAll();
	int generateRouteId();


}
