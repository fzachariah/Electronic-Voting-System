/**
 * @author Team05
 *ProfileDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import com.wipro.evs.bean.ProfileBean;

public interface ProfileDAO {
	/**
	 * @param profileBean PARAMETER
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createProfile(ProfileBean profileBean) throws SQLException;

	

	/**
	 * @param userId PARAMETER
	 * @return the profileBean
	 * @throws SQLException SQL OPERATION
	 */
	ProfileBean findByID(String userId) throws SQLException;

	
}
