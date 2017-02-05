package com.wipro.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.dao.CredentialsDAO;

@Service
@Transactional
public class AuthenticationImpl implements Authentication 
{
	@Autowired
	public CredentialsDAO cred_dao;

	@Override
	public boolean authenticate(CredentialsBean credentialsBean)
	{
		CredentialsBean cred_bean=cred_dao.findByID(credentialsBean.getUserID());
		if(cred_bean!=null)
		{
			if(credentialsBean.getPassword().equals(cred_bean.getPassword()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String authorize(String userID) 
	{
		if(userID!=null)
		{
			CredentialsBean cred_bean=cred_dao.findByID(userID);
			changeLoginStatus(cred_bean, 1);
			return (cred_bean.getUserType());
		}
		return null;		
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) 
	{
	if(credentialsBean!=null){	
		
		credentialsBean.setLoginStatus(loginStatus);
		cred_dao.updateCredentials(credentialsBean);
		return true;
	}
	return false;
	}
}
