/**
 * @author Team05
 *CredentialsDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;

public interface CredentialsDAO {
	/**
	 * @param profileBean PARAMETER
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createCredentials(ProfileBean profileBean) throws SQLException;

	

	/**
	 * @param credentialsBean PARAMETER
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	boolean updateCredentials(CredentialsBean credentialsBean)
			throws SQLException;

	/**
	 * @param userId PARAMETER
	 * @return the credentialsBean
	 * @throws SQLException SQL OPERATION
	 */
	CredentialsBean findByID(String userId) throws SQLException;

	
}
