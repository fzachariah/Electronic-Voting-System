/**
 * @author Team05
 *EODAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wipro.evs.bean.EOBean;
import com.wipro.evs.util.DBUtilImpl;

public class EODAOImpl implements EODAO {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * @param userId PARAMETER
	 * @return the eoBean
	 * @throws SQLException
	 *             SQL OPERATION
	 */
	@Override
	public EOBean findByID(String userId) throws SQLException {

		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_EO where ElectoralofficerId=?");
		pst.setString(ONE, userId);
		rs = pst.executeQuery();
		EOBean eoBean = new EOBean();
		while (rs.next()) {
			eoBean.setElectoralOfficerID(rs.getString(ONE));
			eoBean.setConstituency(rs.getString(TWO));
		}
		return eoBean;

	}

}
