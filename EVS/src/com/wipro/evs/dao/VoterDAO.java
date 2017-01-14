/**
 * @author Team05
 *VoterDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import com.wipro.evs.bean.VoterBean;

public interface VoterDAO {
	/**
	 * @param voterBean
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	String createVoter(VoterBean voterBean) throws SQLException;

	
}
