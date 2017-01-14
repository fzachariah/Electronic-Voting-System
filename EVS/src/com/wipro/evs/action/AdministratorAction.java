package com.wipro.evs.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.service.AdministratorImpl;
import com.wipro.evs.util.UserImpl;

/**
 * @author Team05 ElectionAction.java com.wipro.evs.action Jan 24, 2014
 */
public class AdministratorAction extends ActionSupport implements SessionAware {
	
	private static final int ZERO = 0;
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Date electionDate;
	private Date countingDate;
	private String userID[];
	private String request;
	private Date dateOfBirth;
	private String electionID;
	private String electionName;
	private String partyID;
	private ElectionBean electionBean;
	private CandidateBean candidateBean;
	private PartyBean partyBean;
	private String electionID1;
	private ArrayList<String> electionName1 = new ArrayList<String>();
	

	/**
	 * @return the electionName1
	 */
	public ArrayList<String> getElectionName1() {
		return electionName1;
	}

	/**
	 * @param electionName1
	 *            the electionName1 to set
	 */
	public void setElectionName1(ArrayList<String> electionName1) {
		this.electionName1 = electionName1;
	}

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
	 * @return the electionID1
	 */
	public String getElectionID1() {
		return electionID1;
	}

	/**
	 * @param electionID1
	 *            the electionID1 to set
	 */
	public void setElectionID1(String electionID1) {
		this.electionID1 = electionID1;
	}

	/**
	 * @return the electionName
	 */
	public String getElectionName() {
		return electionName;
	}

	/**
	 * @param electionName
	 *            the electionName to set
	 */
	public void setElectionName(String electionName) {
		this.electionName = electionName;
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
	 * @return the candidateBean
	 */
	public CandidateBean getCandidateBean() {
		return candidateBean;
	}

	/**
	 * @param candidateBean
	 *            the candidateBean to set
	 */
	public void setCandidateBean(CandidateBean candidateBean) {
		this.candidateBean = candidateBean;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
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
	 * @return the partyBean
	 */
	public PartyBean getPartyBean() {
		return partyBean;
	}

	/**
	 * @param partyBean
	 *            the partyBean to set
	 */
	public void setPartyBean(PartyBean partyBean) {
		this.partyBean = partyBean;
	}

	/**
	 * @return the electionBean
	 */
	public ElectionBean getElectionBean() {
		return electionBean;
	}

	/**
	 * @param electionBean
	 *            the electionBean to set
	 */
	public void setElectionBean(ElectionBean electionBean) {
		this.electionBean = electionBean;
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

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String addElection() throws SQLException, ParseException {
		UserImpl userImpl = new UserImpl();
		AdministratorImpl administrator = new AdministratorImpl();
		electionBean.setElectionDate(userImpl.stringToDate(electionDate));
		electionBean.setCountingDate(userImpl.stringToDate(countingDate));
		String result = "ERROR";
		result = administrator.addElection(electionBean);
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String addParty() throws SQLException, ParseException {
		AdministratorImpl administrator = new AdministratorImpl();
		String result = "ERROR";
		result = administrator.addParty(partyBean);
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewAllElectionDetails() throws SQLException, ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<ElectionBean> electionList=new ArrayList<ElectionBean>();
		 ;
		electionList = administrator.viewElections();
		session.put("AllElectionDetails", electionList);
		String result = "SUCCESS";
		if (electionList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewAllUpcomingElectionDetails() throws SQLException,
			ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<ElectionBean> electionList= new ArrayList<ElectionBean>(); 
		electionList = administrator.viewAllUpcomingElections();
		session.put("UpcomingElectionDetails", electionList);
		String result = "SUCCESS";
		if (electionList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewPartyDetails() throws SQLException, ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<PartyBean> partyList= new ArrayList<PartyBean>();
		partyList = administrator.viewAllParty();
		session.put("PartyDetails", partyList);
		String result = "SUCCESS";
		if (partyList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewPendingVoterIDRequests() throws SQLException,
			ParseException {
		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<ApplicationBean> applicationList= new ArrayList<ApplicationBean>();
		applicationList = administrator.viewAllAdminPendingApplications();
		session.put("VoterIDRequest", applicationList);
		String result = "SUCCESS";
		if (applicationList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String forwardVoterID() throws SQLException, ParseException {
		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<ApplicationBean> applicationList= new ArrayList<ApplicationBean>();
		int size = userID.length;
		for (int i = 0; i < size; i++) {
			administrator.forwardVoterIDRequest(userID[i]);
		}
		applicationList = administrator.viewAllAdminPendingApplications();
		session.put("VoterIDRequest", applicationList);
		String result = "SUCCESS";
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String addCandidateDetails() throws SQLException, ParseException {
		UserImpl userImpl = new UserImpl();
		AdministratorImpl administrator = new AdministratorImpl();
		candidateBean.setDateOfBirth(userImpl.stringToDate(dateOfBirth));
		String result = "ERROR";
		result = administrator.addCandidate(candidateBean);
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */ 
	public String viewCandidateDetailsByElectionID() throws SQLException,
			ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<CandidateBean> candidateList= new ArrayList<CandidateBean>();
 
		candidateList = administrator
				.viewCandidateDetailsByElectionID(electionID);
		session.put("CandidateDetails-Election", candidateList);
		String result = "SUCCESS";
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewCandidateDetailsByParty() throws SQLException,
			ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<CandidateBean> candidateList = new ArrayList<CandidateBean>();
		
		candidateList = administrator.viewCandidateDetailsByParty(partyID);
		session.put("CandidateDetails-Election", candidateList);
		String result = "SUCCESS";
		if (candidateList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String viewCandidateDetailsByElectionName() throws SQLException,
			ParseException {

		AdministratorImpl administrator = new AdministratorImpl();
		ArrayList<CandidateBean> candidateList= new ArrayList<CandidateBean>();
		candidateList = administrator
				.viewCandidateDetailsByElectionName(electionName);
		session.put("CandidateDetails-Election", candidateList);
		String result = "SUCCESS";
		if (candidateList.size() == ZERO) {
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	public String supportApproveResults() throws SQLException, ParseException {
		String result = "SUCCESS";
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 * @throws ParseException DATE OPERATION
	 */
	@SuppressWarnings("unchecked")
	public String adminApprovalOfResults() throws SQLException, ParseException {
		AdministratorImpl adminImpl = new AdministratorImpl();
		Map<String, ArrayList<ElectionBean>> mapp = new HashMap<String, ArrayList<ElectionBean>>();
		String result = null;
		int voterCount = adminImpl.minVoteCount();
		if (voterCount < 1) {
			result = "FAILURE";
		} else {
			mapp = adminImpl.approveElectionResults(electionID1);
			session.put("ElectionResult", mapp.get("electionList"));
			result = "SUCCESS";
		}
		return result;

	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String viewElectionByName() throws SQLException {
		AdministratorImpl administrator = new AdministratorImpl();
		electionName1 = administrator.electionName();
		session.put("ElectionName", electionName1);
		String result = "SUCCESS";
		return result;
	}

}
