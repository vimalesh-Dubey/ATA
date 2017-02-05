package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.CredentialsBean;



public interface CredentialsDAO 
{
	String createCredentials( CredentialsBean credentialsBean);
	int deleteCredentials(ArrayList<String> CredentialsList) ;
	boolean updateCredentials(CredentialsBean credentialsBean) ;
	CredentialsBean findByID(String id) ;
	ArrayList<CredentialsBean> findAll();

}
