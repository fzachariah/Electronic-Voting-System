/**
 * @author Team05
 *ElectoralOfficerImpl.java
 *com.wipro.evs.service
 *Jan 22, 2014
 */
package com.wipro.evs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.dao.ApplicationDAOImpl;

public class ElectoralOfficerImpl implements ElectoralOfficer {
	

	/**
	 * @param userId
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String generateVoterId(String userId) throws SQLException {
		ApplicationDAOImpl applicationDAO=new ApplicationDAOImpl();
		
		ApplicationBean applicationBean=new ApplicationBean();
		applicationBean=applicationDAO.findByID(userId);
		System.out.println(applicationBean.getUserID()+""+applicationBean.getConstituency());
		String result=applicationDAO.updateEOApplication(applicationBean);
		return result;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ApplicationBean> viewAllVoterIdApplications(String userId) throws SQLException {
		ArrayList<ApplicationBean> list=new ArrayList<ApplicationBean>();
		ApplicationDAOImpl applicationDAO=new ApplicationDAOImpl();
		list=applicationDAO.findAllRequest(userId);
		return list;

	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<ApplicationBean> viewAllVoterIdApplications()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param userID 
	 * @throws SQLException SQL OPERATION
	 */
	public void rejectVoterIDRequest(String userID) throws SQLException
	{
		ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
		applicationDAO.updateEORejectApplication(userID);
	}

	
	
}
