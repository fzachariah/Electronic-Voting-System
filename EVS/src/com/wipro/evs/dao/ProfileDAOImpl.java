/**
 * @author Team05
 *ProfileDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.DBUtilImpl;

public class ProfileDAOImpl implements ProfileDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;
	private static final int EIGHT = 8;
	private static final int NINE = 9;
	private static final int TEN = 10;
	private static final int ELEVEN = 11;
	private static final int TWELVE = 12;
	private Connection con;

	/**
	 * @param profileBean
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createProfile(ProfileBean profileBean) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("insert into EVS_TBL_User_Profile (userid, firstname, lastname, dateofbirth, gender, street, location, city, state, pincode, mobileno, emailid) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(ONE, profileBean.getUserID());
		pst.setString(TWO, profileBean.getFirstName());
		pst.setString(THREE, profileBean.getLastName());
		pst.setDate(FOUR, profileBean.getDateOfBirth());
		pst.setString(FIVE, profileBean.getGender());
		pst.setString(SIX, profileBean.getStreet());
		pst.setString(SEVEN, profileBean.getLocation());
		pst.setString(EIGHT, profileBean.getCity());
		pst.setString(NINE, profileBean.getState());
		pst.setString(TEN, profileBean.getPincode());
		pst.setString(ELEVEN, profileBean.getMobileNo());
		pst.setString(TWELVE, profileBean.getEmailID());
		pst.executeUpdate();

		con.commit();
		return "SUCCESS";
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.evs.dao.ProfileDAO#findByID(java.lang.String)
	 */
	/**
	 * @param userId PARAMETER
	 * @return the profileBean
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ProfileBean findByID(String userId) throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_User_Profile where UserId=?");
		pst.setString(1, userId);
		rs = pst.executeQuery();
		ProfileBean profileBean = new ProfileBean();
		while (rs.next()) {
			profileBean.setCity(rs.getString(EIGHT));
		}
		return profileBean;
	}

	

}
