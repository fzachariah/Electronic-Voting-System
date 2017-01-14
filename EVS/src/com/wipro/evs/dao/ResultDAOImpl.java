/**
 * @author Team05
 *ResultDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.util.DBUtilImpl;

public class ResultDAOImpl implements ResultDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;

	/**
	 * @param resultBean PARAMETER
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createResult(ResultBean resultBean) throws SQLException {
		Connection con;
		PreparedStatement pst;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("insert into EVS_TBL_Result values(EVS_SEQ_RESULTSERIALNO.nextval,'"
						+ resultBean.getElectionID()
						+ "','"
						+ resultBean.getCandidateID()
						+ "','"
						+ resultBean.getVoteCount() + "')");

		pst.executeUpdate();

		con.commit();

		return null;
	}

	
	
	/**
	 * @param userId PARAMETER
	 * @return the resultBean
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ResultBean findByID(String userId) throws SQLException {
		return null;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<ResultBean> findAll() throws SQLException {
		Connection con;
		PreparedStatement pst;
		PreparedStatement pst1;
		PreparedStatement pst2;
		ResultSet rs;
		ResultSet rs1;
		ResultSet rs2;
		DBUtilImpl dbUtil = new DBUtilImpl();

		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select count(unique electionid) from EVS_TBL_Result");
		rs = pst.executeQuery();
		con.commit();
		int size = 0;
		while (rs.next()) {
			size = rs.getInt(ONE);
		}

		pst = con
				.prepareStatement("select unique electionid from EVS_TBL_Result");
		rs = pst.executeQuery();
		con.commit();
		String electionID[] = new String[size];
		int count = 0;
		while (rs.next()) {
			electionID[count++] = rs.getString(ONE);
		}

		pst1 = con
				.prepareStatement("select serialno,electionid,candidateid,votecount from EVS_TBL_Result");
		rs1 = pst1.executeQuery();
		con.commit();

		ArrayList<ResultBean> list = new ArrayList<ResultBean>();
		int countArray[] = new int[size];
		while (rs1.next()) {
			ResultBean resultBean = new ResultBean();
			resultBean.setSerailNo(rs1.getInt(ONE));
			resultBean.setElectionID(rs1.getString(TWO));
			resultBean.setCandidateID(rs1.getString(THREE));
			resultBean.setVoteCount(rs1.getInt(FOUR));
			for (int i = 0; i < size; i++) {
				if (resultBean.getElectionID().equals(electionID[i])) {
					if (resultBean.getVoteCount() > countArray[i]) {
						countArray[i] = resultBean.getVoteCount();
					}
				}
			}
		}

		pst2 = con
				.prepareStatement("select serialno,electionid,candidateid,votecount from EVS_TBL_Result");
		rs2 = pst2.executeQuery();
		con.commit();
		while (rs2.next()) {
			ResultBean resultBean = new ResultBean();
			resultBean.setSerailNo(rs2.getInt(ONE));
			resultBean.setElectionID(rs2.getString(TWO));
			resultBean.setCandidateID(rs2.getString(THREE));
			resultBean.setVoteCount(rs2.getInt(FOUR));
			for (int i = 0; i < size; i++) {
				if (resultBean.getElectionID().equals(electionID[i])) {
					if (resultBean.getVoteCount() == countArray[i]) {
						list.add(resultBean);
					}
				}
			}

		}
		return list;
	}

}
