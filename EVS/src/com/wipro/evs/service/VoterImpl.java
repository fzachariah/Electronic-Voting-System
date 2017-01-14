/**
 * @author Team05
 *VoterImpl.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.bean.VoterBean;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.ProfileDAOImpl;
import com.wipro.evs.dao.ResultDAOImpl;
import com.wipro.evs.dao.VoterDAOImpl;

public class VoterImpl implements Voter {

	private static final int ONE = 1;
	private static final int THREE = 3;
	private static final int ZERO = 0;

	/**
	 * @param userId
	 * @param electionId
	 * @param candiadteId
	 * @return the null
	 * @throws SQLException SQL OPERATION
	 */
	public String castVote(String userId, String electionId, String candiadteId)
			throws SQLException {
		VoterDAOImpl voterDAO = new VoterDAOImpl();
		VoterBean voterBean = new VoterBean();
		voterBean.setCandidateID(candiadteId);
		voterBean.setElectionID(electionId);
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean = applicationDAO.findByID(userId);
		voterBean.setVoterID(applicationBean.getVoterID());
		voterDAO.createVoter(voterBean);
		return null;

	}

	/**
	 * @param electionName
	 * @param constituency
	 * @return the null
	 */
	public ArrayList<CandidateBean> viewCandidatesByElectionName(
			String electionName, String constituency) {
		return null;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ResultBean> viewListOfElectionsResults()
			throws SQLException {
		ResultDAOImpl resultDAO = new ResultDAOImpl();
		ArrayList<ResultBean> list = new ArrayList<ResultBean>();
		list = resultDAO.findAll();
		return list;

	}

	/**
	 * @param userId
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String requestVoterId(String userId) throws SQLException {
		ProfileDAOImpl profileDAO = new ProfileDAOImpl();
		ProfileBean profileBean = new ProfileBean();
		profileBean = profileDAO.findByID(userId);
		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean.setConstituency(profileBean.getCity());
		applicationBean.setUserID(userId);
		ApplicationDAOImpl applicationDAOImpl = new ApplicationDAOImpl();
		String result = "FAIL";

		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		ApplicationBean applicationBean1 = applicationDAO.findByID(userId);

		if (applicationBean1.getPassedStatus() > ZERO) {
			if (applicationBean1.getPassedStatus() == THREE
					&& applicationBean1.getApprovedStatus() == ZERO)
			{
				result = "REJECTED";
			}
			else if (applicationBean1.getPassedStatus() == THREE
					&& applicationBean1.getApprovedStatus() == ONE)
			{
				result = "GENERATED";
			}
			else
			{
				result = "APPLIED";
			}
		} else
		{
			result = applicationDAOImpl.createApplication(applicationBean);
		}
		return result;

	}

	/**
	 * @param userId
	 * @param constituency
	 * @return the voterID
	 * @throws SQLException SQL OPERATION
	 */
	public String viewGeneratedVoterId(String userId, String constituency)
			throws SQLException {
		String voterID = "FAIL";
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean = applicationDAO.findVoterID(userId);
		if (applicationBean.getPassedStatus() == THREE) {
			if (applicationBean.getApprovedStatus() == ONE)
			{
				voterID = applicationBean.getVoterID();
			}
			else if (applicationBean.getApprovedStatus() == ZERO)
			{
				voterID = "REJECTED";
			}
			else
			{
				voterID = "PENDING";
			}
		} else
		{
			voterID = "PENDING";
		}
		return voterID;

	}

	/**
	 * @return the null
	 */
	public ArrayList<ElectionBean> viewListOfElections() {
		return null;

	}

	public ArrayList<Object> supportCastVote(String constituency,
			String electionID) throws SQLException {
		ArrayList<Object> list = new ArrayList<Object>();
		VoterDAOImpl voterDAO = new VoterDAOImpl();
		list = voterDAO.supportAll(constituency, electionID);
		return list;

	}

	public ApplicationBean getConstituency(String userId) throws SQLException {
		ApplicationBean applicationBean = new ApplicationBean();
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		applicationBean = applicationDAO.findByID(userId);
		return applicationBean;
	}

	public boolean voted(String voterID) throws SQLException {
		VoterDAOImpl voterDAO = new VoterDAOImpl();
		boolean vote = voterDAO.findByVoterID(voterID);
		return vote;
	}

	public String getElectionID(String constituency) throws SQLException {
		ElectionDAOImpl electionDAO1 = new ElectionDAOImpl();
		String electionID = electionDAO1.electionDate(constituency);
		return electionID;

	}

}
