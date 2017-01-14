/**
 * @author Team05
 *PartyDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.PartyBean;

public interface PartyDAO {
	/**
	 * @param partyBean PARAMETER
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createParty(PartyBean partyBean) throws SQLException;

	

	/**
	 * @return the list
	 * @throws SQLException
	 */
	ArrayList<PartyBean> findAll() throws SQLException;
}
