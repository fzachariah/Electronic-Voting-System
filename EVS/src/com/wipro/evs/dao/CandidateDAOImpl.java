/**
 * @author Team05
 *CandidateDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.util.DBUtilImpl;

public class CandidateDAOImpl implements CandidateDAO {
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
	private static final int ZERO = 0;
	private Connection con;

	/**
	 * @param candidateBean PARAMETER
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createCandidate(CandidateBean candidateBean)
			throws SQLException {
		PreparedStatement pst;
		PreparedStatement pst1;
		ResultSet rs;
		int sequence = 0;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst1 = con
				.prepareStatement("select evs_seq_candidateId.nextval from dual");
		rs = pst1.executeQuery();
		while (rs.next()) {
			sequence = rs.getInt(ONE);
		}
		String name = candidateBean.getName().substring(ZERO, TWO);
		candidateBean.setCandidateID(name + sequence);
		pst = con
				.prepareStatement("insert into EVS_TBL_Candidate values(?,?,?,?,?,?,?,?,?,?)");
		pst.setString(ONE, candidateBean.getCandidateID());
		pst.setString(TWO, candidateBean.getName());
		pst.setString(THREE, candidateBean.getElectionID());
		pst.setString(FOUR, candidateBean.getPartyID());
		pst.setString(FIVE, candidateBean.getDistrict());
		pst.setString(SIX, candidateBean.getConstituency());
		pst.setDate(SEVEN, candidateBean.getDateOfBirth());
		pst.setString(EIGHT, candidateBean.getMobileNo());
		pst.setString(NINE, candidateBean.getAddress());
		pst.setString(TEN, candidateBean.getEmailID());
		int count = pst.executeUpdate();

		con.commit();
		String result = "null";
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
	 * @param userId PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<CandidateBean> findByID(String userId) throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Candidate where electionid='"
						+ userId + "'");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		while (rs.next()) {
			CandidateBean candidateBean = new CandidateBean();
			candidateBean.setCandidateID(rs.getString(ONE));
			candidateBean.setName(rs.getString(TWO));
			candidateBean.setElectionID(rs.getString(THREE));
			candidateBean.setPartyID(rs.getString(FOUR));
			candidateBean.setDistrict(rs.getString(FIVE));
			candidateBean.setConstituency(rs.getString(SIX));
			candidateBean.setDateOfBirth(rs.getDate(SEVEN));
			candidateBean.setMobileNo(rs.getString(EIGHT));
			candidateBean.setAddress(rs.getString(NINE));
			candidateBean.setEmailID(rs.getString(TEN));
			list.add(candidateBean);
		}
		return list;
	}

	

	/**
	 * @param partyId PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<CandidateBean> findByPartyID(String partyId)
			throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Candidate where partyid='"
						+ partyId + "'");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<CandidateBean> list;
		list = new ArrayList<CandidateBean>();
		while (rs.next()) {
			CandidateBean candidateBean = new CandidateBean();
			candidateBean.setCandidateID(rs.getString(ONE));
			candidateBean.setName(rs.getString(TWO));
			candidateBean.setElectionID(rs.getString(THREE));
			candidateBean.setPartyID(rs.getString(FOUR));
			candidateBean.setDistrict(rs.getString(FIVE));
			candidateBean.setConstituency(rs.getString(SIX));
			candidateBean.setDateOfBirth(rs.getDate(SEVEN));
			candidateBean.setMobileNo(rs.getString(EIGHT));
			candidateBean.setAddress(rs.getString(NINE));
			candidateBean.setEmailID(rs.getString(TEN));
			list.add(candidateBean);
		}
		return list;
	}

	/**
	 * @param electionName PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<CandidateBean> findByName(String electionName)
			throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Candidate inner join EVS_TBL_Election on EVS_TBL_Candidate.electionid=EVS_TBL_Election.electionid where EVS_TBL_Election.name='"
						+ electionName + "'");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<CandidateBean> list=new ArrayList<CandidateBean>();
		while (rs.next()) {
			CandidateBean candidateBean = new CandidateBean();
			candidateBean.setCandidateID(rs.getString(ONE));
			candidateBean.setName(rs.getString(TWO));
			candidateBean.setElectionID(rs.getString(THREE));
			candidateBean.setPartyID(rs.getString(FOUR));
			candidateBean.setDistrict(rs.getString(FIVE));
			candidateBean.setConstituency(rs.getString(SIX));
			candidateBean.setDateOfBirth(rs.getDate(SEVEN));
			candidateBean.setMobileNo(rs.getString(EIGHT));
			candidateBean.setAddress(rs.getString(NINE));
			candidateBean.setEmailID(rs.getString(TEN));
			list.add(candidateBean);
		}
		return list;
	}

	/**
	 * @return the list 
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<String> partyIDList() throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con.prepareStatement("select partyID from EVS_TBL_Party");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<String> list=new ArrayList<String>();;
	 
		while (rs.next()) {
			list.add(rs.getString(ONE));
		}
		return list;
	}

}
