/**
 * @author Team05
 *DBUtilImpl.java
 *com.wipro.evs.util
 *Jan 22, 2014
 */
package com.wipro.evs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilImpl implements DBUtil {
	/**
	 * @param driverType
	 * @return the connection
	 */
	public Connection getDBConnection(/* String driverType */) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL", "scott",
					"wipro123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

}
