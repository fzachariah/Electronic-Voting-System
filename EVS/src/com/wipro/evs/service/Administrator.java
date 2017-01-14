
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;

/**
 * @author Team05
 *Administrator.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
public interface Administrator {
	String addElection(ElectionBean electionBean) throws SQLException;

	ArrayList<ElectionBean> viewAllUpcomingElections() throws SQLException;

	ArrayList<ElectionBean> viewElections() throws SQLException;

	String addParty(PartyBean partyBean) throws SQLException;

	ArrayList<PartyBean> viewAllParty() throws SQLException;

	String addCandidate(CandidateBean candidateBean) throws SQLException;

	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(
			String electionName) throws SQLException;

	ArrayList<ApplicationBean> viewAllAdminPendingApplications()
			throws SQLException;

	boolean forwardVoterIDRequest(String userId) throws SQLException;

	ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId)
			throws SQLException;

	@SuppressWarnings("rawtypes")
	Map approveElectionResults(String electionId) throws SQLException;
}
