package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.ProfileBean;

public interface ProfileBeanDAO 
{
	String createProfileBean(ProfileBean pb);
	int deleteProfileBean(ArrayList<String> list); 
	boolean updateProfileBean(ProfileBean pb); 
	ProfileBean findByID(String id);
	ArrayList<ProfileBean> findAll();
	public int generateUserId();
	
	

	
	
	




}
