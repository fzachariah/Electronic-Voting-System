/**
 * @author Team05
 *AdministratorImpl.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ApplicationDAOImpl;
import com.wipro.evs.dao.CandidateDAOImpl;
import com.wipro.evs.dao.ElectionDAOImpl;
import com.wipro.evs.dao.PartyDAOImpl;
import com.wipro.evs.dao.ResultDAOImpl;
import com.wipro.evs.dao.VoterDAOImpl;

public class AdministratorImpl implements Administrator {

	/**
	 * @param electionBean
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String addElection(ElectionBean electionBean) throws SQLException {
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		String result = electionDAO.createElection(electionBean);
		return result;
	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ElectionBean> viewAllUpcomingElections()
			throws SQLException {
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		ArrayList<ElectionBean> list= new ArrayList<ElectionBean>();
		list = electionDAO.findUpcoming();
		return list;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */ 
	public ArrayList<ElectionBean> viewElections() throws SQLException {
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		ArrayList<ElectionBean> list=new ArrayList<ElectionBean>();
		
		list = electionDAO.findAll();
		return list;

	}

	/**
	 * @param partyBean
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String addParty(PartyBean partyBean) throws SQLException {
		PartyDAOImpl partyDAO = new PartyDAOImpl();
		String result = partyDAO.createParty(partyBean);
		return result;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<PartyBean> viewAllParty() throws SQLException {
		PartyDAOImpl partyDAO = new PartyDAOImpl();
		ArrayList<PartyBean> list = new ArrayList<PartyBean>();

		list = partyDAO.findAll();
		return list;

	}

	/**
	 * @param candidateBean
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String addCandidate(CandidateBean candidateBean) throws SQLException {
		CandidateDAOImpl candidateDAO = new CandidateDAOImpl();
		String result = candidateDAO.createCandidate(candidateBean);
		return result;
	}

	/**
	 * @param electionName
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionID(
			String electionID) throws SQLException {
		CandidateDAOImpl candidateDAO = new CandidateDAOImpl();
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		list = candidateDAO.findByID(electionID);
		return list;

	}

	/**
	 * @param electionName
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(
			String electionName) throws SQLException {
		CandidateDAOImpl candidateDAO = new CandidateDAOImpl();
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		list = candidateDAO.findByName(electionName);
		return list;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications()
			throws SQLException {
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		ArrayList<ApplicationBean> list=new ArrayList<ApplicationBean>();
		
		list = applicationDAO.findAll();
		return list;

	}

	/**
	 * @param userId
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean forwardVoterIDRequest(String userId) throws SQLException {
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean.setUserID(userId);
		applicationDAO.updateApplication(applicationBean);
		return true;

	}

	/**
	 * @param partyId
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */ 
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId)
			throws SQLException {
		CandidateDAOImpl candidateDAO = new CandidateDAOImpl();
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		list = candidateDAO.findByPartyID(partyId);
		return list;

	}

	/**
	 * @param electionId
	 * @return the map
	 * @throws SQLException SQL OPERATION
	 */
	@SuppressWarnings("rawtypes")
	public Map approveElectionResults(String electionId) throws SQLException {
		VoterDAOImpl voterDAO = new VoterDAOImpl();
		ArrayList<ResultBean> list = new ArrayList<ResultBean>();
		list = voterDAO.findByElectionID(electionId);
		ResultDAOImpl resultDAO = new ResultDAOImpl();
		Iterator<ResultBean> itr = list.iterator();
		while (itr.hasNext()) {
			resultDAO.createResult(itr.next());
		}
		ArrayList<ElectionBean> electionList= new ArrayList<ElectionBean>();
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		
		electionList = electionDAO.getelectionDate();
		Map<String, ArrayList<ElectionBean>> mapp = new HashMap<String, ArrayList<ElectionBean>>();
		mapp.put("electionList", electionList);
		return mapp;

	}

	/**
	 * @return the voterCount
	 * @throws SQLException SQL OPERATION
	 */
	public int minVoteCount() throws SQLException {
		VoterDAOImpl voterDAO = new VoterDAOImpl();
		int voterCount = voterDAO.countVoters();
		return voterCount;
	}

	/**
	 * @return the electionName
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<String> electionName() throws SQLException {
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		ArrayList<String> electionName = new ArrayList<String>();
		electionName = electionDAO.electionName();
		return electionName;
	}

}
