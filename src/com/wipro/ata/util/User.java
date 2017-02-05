package com.wipro.ata.util;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;

public interface User 
{
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean);
}
