/**
 * @author Team05
 *CandidateDAO.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;

public interface CandidateDAO {
	/**
	 * @param candidateBean PARAMETER
	 * @return the candidateBean
	 * @throws SQLException SQL OPERATION
	 */
	String createCandidate(CandidateBean candidateBean) throws SQLException;


	/**
	 * @param userId PARAMETER
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	ArrayList<CandidateBean> findByID(String userId) throws SQLException;

	
}
