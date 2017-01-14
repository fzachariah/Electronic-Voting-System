package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.EOBean;
import com.wipro.evs.util.DBUtilImpl;

/**
 * @author Team05 ApplicationDAOImpl.java com.wipro.evs.dao Jan 22, 2014
 */
public class ApplicationDAOImpl implements ApplicationDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int ZER0 = 0;

	/**
	 * @param applicationBean PARAMETER
	 * @return the result RETURN
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createApplication(ApplicationBean applicationBean)
			throws SQLException {
		Connection con;
		PreparedStatement pst;

		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("insert into EVS_TBL_Application (userid, constituency, passedstatus, voterid) values(?,?,1,evs_seq_requestId.nextval)");
		pst.setString(ONE, applicationBean.getUserID());
		pst.setString(TWO, applicationBean.getConstituency());
		int count = pst.executeUpdate();
		con.commit();
		String result = "FAIL";
		if (count == 1) {
			result = "SUCCESS";
		}
		return result;
	}

	/**
	 * @param applicationBean PARAMETER
	 * @return THE BOOLEAN
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public boolean updateApplication(ApplicationBean applicationBean)
			throws SQLException {
		Connection con;
		PreparedStatement pst;

		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		String userid = applicationBean.getUserID();

		pst = con
				.prepareStatement("UPDATE EVS_TBL_Application set Passedstatus=2 where Userid='"
						+ userid + "'");
		int count = pst.executeUpdate();
		con.commit();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param userId PARAMETER
	 * @return the applicationBean RETURN 
	 * @throws SQLException SQL OPERATION
	 */ 
	@Override
	public ApplicationBean findByID(String userId) throws SQLException {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		DBUtilImpl dbUtil = new DBUtilImpl();

		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from  EVS_TBL_Application where UserId=?");
		pst.setString(1, userId);
		rs = pst.executeQuery();
		ApplicationBean applicationBean = new ApplicationBean();

		while (rs.next()) {
			applicationBean.setUserID(rs.getString(ONE));
			applicationBean.setConstituency(rs.getString(TWO));
			applicationBean.setPassedStatus(rs.getInt(THREE));
			applicationBean.setApprovedStatus(rs.getInt(FOUR));
			applicationBean.setVoterID(rs.getString(FIVE));
		}

		return applicationBean;
	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<ApplicationBean> findAll() throws SQLException {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Application where passedstatus=1");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<ApplicationBean> list;
		list = new ArrayList<ApplicationBean>();
		while (rs.next()) {
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setUserID(rs.getString(ONE));
			applicationBean.setConstituency(rs.getString(TWO));
			list.add(applicationBean);
		}
		return list;
	}

	/**
	 * @param userId PARAMETER
	 * @return the list 
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ApplicationBean> findAllRequest(String userId)
			throws SQLException {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		DBUtilImpl dbUtil = new DBUtilImpl();
		EODAOImpl eoDAO = new EODAOImpl();
		EOBean eoBean = new EOBean();
		eoBean = eoDAO.findByID(userId);
		String constituencyName = eoBean.getConstituency();
		System.out.println(constituencyName);
		con = dbUtil.getDBConnection();
		ArrayList<ApplicationBean> list = new ArrayList<ApplicationBean>();
		pst = con
				.prepareStatement("select * from  EVS_TBL_Application where Passedstatus=2 and constituency='"
						+ constituencyName + "'");
		rs = pst.executeQuery();
		while (rs.next()) {
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setUserID(rs.getString(ONE));
			applicationBean.setConstituency(rs.getString(TWO));
			applicationBean.setVoterID(rs.getString(FIVE));
			list.add(applicationBean);
		}

		return list;
	}

	/**
	 * @param applicationBean PARAMETER
	 * @return result
	 * @throws SQLException SQL OPERATION
	 */
	public String updateEOApplication(ApplicationBean applicationBean)
			throws SQLException {
		Connection con;
		PreparedStatement pst;
		PreparedStatement pst1;

		ResultSet rs;

		int sequence = 0;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst1 = con.prepareStatement("select evs_seq_voterid.nextval from dual");
		rs = pst1.executeQuery();
		while (rs.next()) {
			sequence = rs.getInt(ONE);
		}
		String name = applicationBean.getUserID().substring(ZER0, TWO);
		name = name + applicationBean.getConstituency().substring(ZER0, TWO)
				+ sequence;
		pst = con
				.prepareStatement("UPDATE EVS_TBL_Application set Passedstatus=3, Approvedstatus=1,voterid='"
						+ name
						+ "' where Userid='"
						+ applicationBean.getUserID() + "'");
		int count = pst.executeUpdate();
		con.commit();
		String result = "NULL";
		if (count == 1) {
			result = "SUCCESS";
		} else if (count == 0) {
			result = "FAIL";
		} else {
			result = "ERROR";
		}
		return result;

	}

	/**
	 * @param userID PARAMETER
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean updateEORejectApplication(String userID) throws SQLException {
		Connection con;
		PreparedStatement pst;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();

		pst = con
				.prepareStatement("UPDATE EVS_TBL_Application set Passedstatus=3, Approvedstatus=0 where Userid='"
						+ userID + "'");
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
	 * @return the applicationBean
	 * @throws SQLException SQL OPERATION
	 */
	public ApplicationBean findVoterID(String userId) throws SQLException {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		DBUtilImpl dbUtil = new DBUtilImpl();

		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select VoterId, approvedstatus, passedstatus from  EVS_TBL_Application where UserId=?");
		pst.setString(ONE, userId);
		rs = pst.executeQuery();
		ApplicationBean applicationBean = new ApplicationBean();

		while (rs.next()) {
			applicationBean.setVoterID(rs.getString(ONE));
			applicationBean.setApprovedStatus(rs.getInt(TWO));
			applicationBean.setPassedStatus(rs.getInt(THREE));
		}
		return applicationBean;
	}
}
