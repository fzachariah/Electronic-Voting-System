package com.wipro.evs.bean;

/**
 * @author Team05 ResultBean.java com.wipro.evs.bean Jan 22, 2014
 */
public class ResultBean {
	private int serailNo;
	private String electionID;
	private String candidateID;
	private int voteCount;

	/**
	 * @return the serailNo
	 */
	public int getSerailNo() {
		return serailNo;
	}

	/**
	 * @param serailNo
	 *            the serailNo to set
	 */
	public void setSerailNo(int serailNo) {
		this.serailNo = serailNo;
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
	 * @return the voteCount
	 */
	public int getVoteCount() {
		return voteCount;
	}

	/**
	 * @param voteCount
	 *            the voteCount to set
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

}
