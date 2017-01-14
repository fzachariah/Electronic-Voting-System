package com.wipro.evs.bean;

/**
 * @author Team05 VoterBean.java com.wipro.evs.bean Jan 22, 2014
 */
public class VoterBean {
	private String serialNo;
	private String electionID;
	private String candidateID;
	private String voterID;

	/**
	 * @return the serialNo
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo
	 *            the serialNo to set
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @return the electionID
	 */
	public String getElectionID() {
		return electionID;
	}

	/**
	 * @param electionID
	 *            the electionID to set
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @return the candidateID
	 */
	public String getCandidateID() {
		return candidateID;
	}

	/**
	 * @param candidateID
	 *            the candidateID to set
	 */
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
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
