package com.wipro.evs.bean;

/**
 * @author Team05 ApplicationBean.java com.wipro.evs.bean Jan 22, 2014
 */
public class ApplicationBean {
	private String userID;
	private String constituency;
	private int passedStatus;
	private int approvedStatus;
	private String voterID;

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
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
	 * @return the passedStatus
	 */
	public int getPassedStatus() {
		return passedStatus;
	}

	/**
	 * @param passedStatus
	 *            the passedStatus to set
	 */
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}

	/**
	 * @return the approvedStatus
	 */
	public int getApprovedStatus() {
		return approvedStatus;
	}

	/**
	 * @param approvedStatus
	 *            the approvedStatus to set
	 */
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	/**
	 * @return the voterID
	 */
	public String getVoterID() {
		return voterID;
	}

	/**
	 * @param voterID
	 *            the voterID to set
	 */
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}

}
