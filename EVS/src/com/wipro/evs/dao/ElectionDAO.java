/**
 * @author Team05
 *ElectionDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ElectionBean;

public interface ElectionDAO {
	/**
	 * @param electionBean PARAMETER
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createElection(ElectionBean electionBean) throws SQLException;


	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	ArrayList<ElectionBean> findAll() throws SQLException;

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	ArrayList<ElectionBean> findUpcoming() throws SQLException;
}
