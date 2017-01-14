/**
 * @author Team05
 *ResultDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ResultBean;

public interface ResultDAO {
	/**
	 * @param resultBean PARAMETER
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createResult(ResultBean resultBean) throws SQLException;

	

	/**
	 * @param userId PARAMETER
	 * @return the resultBean
	 * @throws SQLException SQL OPERATION
	 */
	ResultBean findByID(String userId) throws SQLException;

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	ArrayList<ResultBean> findAll() throws SQLException;
}
