
package com.wipro.evs.bean;

import java.sql.Date;

/**
 * @author Team05
 *ElectionBean.java
 *com.wipro.evs.bean
 *Jan 22, 2014
 */
public class ElectionBean {
	private String electionID;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;

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
	 * @return the electionDate
	 */
	public Date getElectionDate() {
		return electionDate;
	}

	/**
	 * @param electionDate
	 *            the electionDate to set
	 */
	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
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
	 * @return the countingDate
	 */
	public Date getCountingDate() {
		return countingDate;
	}

	/**
	 * @param countingDate
	 *            the countingDate to set
	 */
	public void setCountingDate(Date countingDate) {
		this.countingDate = countingDate;
	}

}
