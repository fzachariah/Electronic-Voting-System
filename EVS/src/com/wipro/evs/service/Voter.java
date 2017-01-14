/**
 * @author Team05
 *Voter.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;

public interface Voter {
	String castVote(String userId, String electionId, String candiadteId)
			throws SQLException;

	ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName,
			String constituency);

	ArrayList<ResultBean> viewListOfElectionsResults() throws SQLException;

	String requestVoterId(String userId) throws SQLException;

	String viewGeneratedVoterId(String userId, String constituency)
			throws SQLException;

	ArrayList<ElectionBean> viewListOfElections();
}
