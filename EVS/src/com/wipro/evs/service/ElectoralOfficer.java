/**
 * @author Team05
 *ElectoralOfficer.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;

public interface ElectoralOfficer {
	String generateVoterId(String userId) throws SQLException;

	ArrayList<ApplicationBean> viewAllVoterIdApplications() throws SQLException;
}
