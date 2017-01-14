package com.wipro.evs.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.service.ElectoralOfficerImpl;

/**
 * @author Team05 EOAction.java com.wipro.evs.action Jan 27, 2014
 */
public class EOAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ZERO = 0;
	private Map<String, Object> session;
	private String userID[];
	private String allUserID[];
	private String constituency;

	/**
	 * @return the userID
	 */
	public String[] getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String[] userID) {
		this.userID = userID;
	}

	/**
	 * @return the allUserID
	 */
	public String[] getAllUserID() {
		return allUserID;
	}

	/**
	 * @param allUserID
	 *            the allUserID to set
	 */
	public void setAllUserID(String[] allUserID) {
		this.allUserID = allUserID;
	}

	/**
	 * @return the constituency
	 */
	public String getConstituency() {
		return constituency;
	}

	/**
	 * @param constituency
	 *            the constituency to set
	 */
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String viewAllVoterIDRequests() throws SQLException {
		ElectoralOfficerImpl electoralOfficer = new ElectoralOfficerImpl();
		ArrayList<ApplicationBean> list = new ArrayList<ApplicationBean>();
		String userId=new String();
		userId = (String) session.get("name");
		list = electoralOfficer.viewAllVoterIdApplications(userId);
		session.put("requests", list);
		String result = "SUCCESS";
		if (list.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String generateVoterID() throws SQLException {
		ArrayList<ApplicationBean> list = new ArrayList<ApplicationBean>();
		String userId=new String();
		ElectoralOfficerImpl electoralOfficer = new ElectoralOfficerImpl();
		String result = "ERROR";
		int size = userID.length;
		int fullSize = allUserID.length;
		for (int j = 0; j < fullSize; j++) {
			int count = 0;
			for (int i = 0; i < size; i++) {
				if (userID[i].equals(allUserID[j])) {
					count = 1;
					break;
				}

			}
			if (count == 0) {
				result = "SUCCESS";
				electoralOfficer.rejectVoterIDRequest(allUserID[j]);
			}

			else {
				result = "SUCCESS";
				result = electoralOfficer.generateVoterId(allUserID[j]);
			}

		}

		userId = (String) session.get("name");
		list = electoralOfficer.viewAllVoterIdApplications(userId);
		session.put("requests", list);
		return result;
	}
}
