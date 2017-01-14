/**
 * @author Team05
 *EODAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import com.wipro.evs.bean.EOBean;

public interface EODAO {
	
	/**
	 * @param userId PARAMETER
	 * @return the eoBean
	 * @throws SQLException SQL OPERATION
	 */
	EOBean findByID(String userId) throws SQLException;


}
