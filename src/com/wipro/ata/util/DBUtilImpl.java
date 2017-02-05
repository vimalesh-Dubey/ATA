package com.wipro.ata.util;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Connection;
@Service
@Transactional
public class DBUtilImpl implements DBUtil 
{

	@Override
	public Connection getDBConnection(String driverType)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
