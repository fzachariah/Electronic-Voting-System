/**
 * @author Team05
 *VoterImpl.java
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
import com.wipro.evs.bean.VoterBean;
import com.wipro.evs.util.DBUtilImpl;

public class VoterDAOImpl implements VoterDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private Connection con;
	private PreparedStatement pst;
	private PreparedStatement pst1;
    private ResultSet rs;
	private ResultSet rs1;
	private ResultSet rs2;

	/**
	 * @param voterBean PARAMETER
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createVoter(VoterBean voterBean) throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("insert into EVS_TBL_Voter_Details values(evs_seq_voterserialno.nextval,'"
						+ voterBean.getCandidateID()
						+ "','"
						+ voterBean.getElectionID()
						+ "','"
						+ voterBean.getVoterID() + "')");

		pst.executeUpdate();

		con.commit();

		return null;
	}


	/**
	 * @param constituency PARAMETER
	 * @param electionID PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<Object> supportAll(String constituency, String electionID)
			throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select EVS_TBL_Candidate.Electionid, EVS_TBL_Candidate.CandidateId, EVS_TBL_Candidate.Name, EVS_TBL_Party.partyid, EVS_TBL_Party.symbol from EVS_TBL_Candidate inner join EVS_TBL_Party on EVS_TBL_Candidate.PartyId=EVS_TBL_Party.PartyId where EVS_TBL_Candidate.Constituency='"
						+ constituency
						+ "' and EVS_TBL_Candidate.electionID='"
						+ electionID + "'");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<Object> list = new ArrayList<Object>();
		
		while (rs.next()) {
			list.add(rs.getString(ONE));
			list.add(rs.getString(TWO));
			list.add(rs.getString(THREE));
			list.add(rs.getString(FOUR));
			list.add(rs.getString(FIVE));
		}
		return list;
	}

	/**
	 * @param voterId PARAMETER
	 * @return the vote
	 * @throws SQLException SQL OPERATION
	 */
	public boolean findByVoterID(String voterId) throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select Voterid from EVS_TBL_Voter_Details where Voterid='"
						+ voterId + "'");
		rs = pst.executeQuery();
		con.commit();
		boolean vote = false;
		while (rs.next()) {
			vote = true;
		}
		return vote;
	}

	/**
	 * @param electionId PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ResultBean> findByElectionID(String electionId)
			throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();

		pst = con
				.prepareStatement("select count(distinct Candidateid) from EVS_TBL_Voter_Details where electionid='"
						+ electionId + "'");
		rs2 = pst.executeQuery();
		con.commit();
		int size = 0;

		while (rs2.next()) {
			size = rs2.getInt(ONE);
		}
		System.out.println(size);
		pst1 = con
				.prepareStatement("select distinct Candidateid from EVS_TBL_Voter_Details where electionid='"
						+ electionId + "'");
		rs = pst1.executeQuery();
		con.commit();

		String candidateID[] = new String[size];
		int count = 0;
		while (rs.next()) {
			System.out.println(rs.getString(ONE));
			candidateID[count++] = rs.getString(ONE);

		}

		pst1 = con
				.prepareStatement("select * from EVS_TBL_Voter_Details where electionid='"
						+ electionId + "'");
		rs1 = pst1.executeQuery();
		System.out.println(size);
		int count1[] = new int[size];
		for (int i = 0; i < size; i++) {
			count1[i] = 0;
		}

		ArrayList<ResultBean> list = new ArrayList<ResultBean>();
		while (rs1.next()) {

			for (int i = 0; i < size; i++) {
				if (candidateID[i].equals(rs1.getString(TWO))) {
					count1[i]++;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			ResultBean resultBean = new ResultBean();
			resultBean.setElectionID(electionId);
			resultBean.setCandidateID(candidateID[i]);
			resultBean.setVoteCount(count1[i]);
			list.add(resultBean);
		}
		return list;
	}

	/**
	 * @return the voteNo
	 * @throws SQLException SQL OPERATION
	 */
	public int countVoters() throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select count(*) from EVS_TBL_Voter_Details");
		rs = pst.executeQuery();
		con.commit();
		int voteNo = 0;
		while (rs.next()) {
			voteNo = rs.getInt(ONE);
		}
		return voteNo;
	}

}
