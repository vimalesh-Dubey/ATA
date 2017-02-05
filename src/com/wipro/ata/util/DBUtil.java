package com.wipro.ata.util;

import com.mysql.jdbc.Connection;

public interface DBUtil 
{
	Connection getDBConnection(String driverType);
}
