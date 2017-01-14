package com.wipro.evs.util;

import java.sql.SQLException;

import com.wipro.evs.bean.CredentialsBean;

/**
 * @author Team05 Authentication.java com.wipro.evs.util Jan 22, 2014
 */
public interface Authentication {
	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean authenticate(CredentialsBean user) throws SQLException;

	/**
	 * @param userId
	 * @param validity
	 * @return
	 * @throws SQLException
	 */
	String authorize(String userId, boolean validity) throws SQLException;

	/**
	 * @param user
	 * @param loginStatus
	 * @return
	 * @throws SQLException
	 */
	boolean changeLoginStatus(CredentialsBean user, int loginStatus)
			throws SQLException;
}
