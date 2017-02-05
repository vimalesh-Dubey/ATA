package com.wipro.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;
import com.wipro.ata.dao.CredentialsDAO;
import com.wipro.ata.dao.CreditCardDAO;
import com.wipro.ata.dao.ProfileBeanDAO;
@Service
@Transactional
public class UserImpl implements User
{
	@Autowired
	public Authentication authenticate;
	@Autowired
	public CredentialsDAO cred_dao;
	@Autowired
	private ProfileBeanDAO profileBeandao;
	//@Autowired
	//private CredentialsBean credentialsBean;
	

	@Override
	public String login(CredentialsBean credentialsBean) 
	{
		if(credentialsBean==null||credentialsBean.getUserID().equals("")||
				credentialsBean.getPassword().equals(""))
		{
			return "INVALID";
		}
			if(authenticate.authenticate(credentialsBean))
			{
				String res=authenticate.authorize(credentialsBean.getUserID());
				return res;
			}
				return "FAIL";
			
		}
		
	

	@Override
	public boolean logout(String userId) 
	{
                CredentialsBean credentialsBean=cred_dao.findByID(userId);
		if(credentialsBean!=null)
		{
			authenticate.changeLoginStatus(credentialsBean, 0);
			return true;
		}
		else
		{
		return false;
		}

		
		
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) 
	{
		if(credentialsBean==null||newPassword==null||
				credentialsBean.getPassword()==newPassword)	
		{
			return "INVALID";
		}
		else
		{
			credentialsBean.setPassword(newPassword);
			if(cred_dao.updateCredentials(credentialsBean))
			{
				return "SUCCESS";
			}
			return "FAIL";
			
		}
		
	}

	@Override
	public String register(ProfileBean profileBean) 
	{
		try
		{
			CredentialsBean credentialsBean = new CredentialsBean();
			int id=profileBeandao.generateUserId();
			String user_id=profileBean.getLastName().substring(0, 2)+id;
			profileBean.setUserId(user_id);
			credentialsBean.setUserID(user_id);
			credentialsBean.setPassword(profileBean.getPassword());
			credentialsBean.setLoginStatus(0);
			credentialsBean.setUserType("C");
			//adding to profile table
			String result = profileBeandao.createProfileBean(profileBean);
			//adding to credential table
			cred_dao.createCredentials(credentialsBean);
			
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
