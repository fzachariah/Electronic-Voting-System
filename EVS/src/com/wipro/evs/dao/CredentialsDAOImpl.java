/**
 * @author Team05
 *CredentialsDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.DBUtilImpl;

public class CredentialsDAOImpl implements CredentialsDAO {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int ZERO = 0;
	private Connection con;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private ResultSet rs;

	/**
	 * @param profileBean PARAMETER
	 * @return the name
	 * @throws SQLException SQL OPERATION
	 */
	public String createCredentials(ProfileBean profileBean)
			throws SQLException {
		// TODO Auto-generated method stub
		int sequence = 0;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst1 = con.prepareStatement("select evs_seq_userid.nextval from dual");
		rs = pst1.executeQuery();
		while (rs.next()) {
			sequence = rs.getInt(ONE);
		}
		String name = profileBean.getFirstName().substring(ZERO, TWO);
		name = name + sequence;
		pst = con
				.prepareStatement("insert into EVS_TBL_User_Credentials (userid, password, usertype, loginstatus) values(? ,'password','V',0)");
		pst.setString(ONE, name);
		pst.executeUpdate();

		con.commit();
		// System.out.println(count);
		return name;
	}

	

	/**
	 * @param credentialsBean PARAMETER
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public boolean updateCredentials(CredentialsBean credentialsBean)
			throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		String password = credentialsBean.getPassword();
		String userid = credentialsBean.getUserID();

		pst = con
				.prepareStatement("UPDATE EVS_TBL_User_Credentials set PASSWORD='"
						+ password + "' where userid='" + userid + "'");
		int count = pst.executeUpdate();
		con.commit();
		// System.out.println(count);
		if (count > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param credentialsBean PARAMETER
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean updateCredentialsStatus(CredentialsBean credentialsBean)
			throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		int status = credentialsBean.getLoginStatus();
		String userid = credentialsBean.getUserID();

		pst = con
				.prepareStatement("UPDATE EVS_TBL_User_Credentials set LOGINSTATUS="
						+ status + " where userid='" + userid + "'");
		int count = pst.executeUpdate();
		con.commit();
		// System.out.println(count);
		if (count > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param userId PARAMETER
	 * @return credentialsBean 
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public CredentialsBean findByID(String userId) throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_User_Credentials where UserId=?");
		pst.setString(ONE, userId);
		rs = pst.executeQuery();
		CredentialsBean credentilasBean = new CredentialsBean();
		while (rs.next()) {
			credentilasBean.setUserID(rs.getString(ONE));
			credentilasBean.setPassword(rs.getString(TWO));
			credentilasBean.setUserType(rs.getString(THREE));
			credentilasBean.setLoginStatus(rs.getInt(FOUR));
		}
		return credentilasBean;

	}

	
	/**
	 * @param userID PARAMETER
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean updateCredentialsStatusLogout(String userID)
			throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		int status = 0;

		pst = con
				.prepareStatement("UPDATE EVS_TBL_User_Credentials set LOGINSTATUS="
						+ status + " where userid='" + userID + "'");
		int count = pst.executeUpdate();
		con.commit();
		if (count == 1) {
			return true;
		} else {
			return false;
		}

	}

}
