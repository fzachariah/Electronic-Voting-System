/**
 * @author Team05
 *ApplicationDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

public interface ApplicationDAO {
	/**
	 * @param applicationBean PARAMETER
	 * @return the string RETURN
	 * @throws SQLException SQL OPERATION
	 */
	String createApplication(ApplicationBean applicationBean)
			throws SQLException;

	

	/**
	 * @param applicationBean PARAMETER 
	 * @return the boolean RETURN
	 * @throws SQLException SQL OPERATION
	 */
	boolean updateApplication(ApplicationBean applicationBean)
			throws SQLException;

	/**
	 * @param userId PARAMETER
	 * @return the applicationBean RETURN
	 * @throws SQLException SQL OPERATION
	 */
	ApplicationBean findByID(String userId) throws SQLException;

	/**
	 * @return the list RETURN
	 * @throws SQLException SQL OPERATION
	 */
	ArrayList<ApplicationBean> findAll() throws SQLException;
}
