package com.wipro.evs.bean;

import java.sql.Date;

/**
 * @author Team05 CandidateBean.java com.wipro.evs.bean Jan 22, 2014
 */
public class CandidateBean {
	private String candidateID;
	private String name;
	private String electionID;
	private String partyID;
	private String district;
	private String constituency;
	private Date dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailID;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the partyID
	 */
	public String getPartyID() {
		return partyID;
	}

	/**
	 * @param partyID
	 *            the partyID to set
	 */
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
