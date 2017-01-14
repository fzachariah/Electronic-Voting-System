package com.wipro.evs.action;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.service.VoterImpl;
import com.wipro.evs.util.UserImpl;

/**
 * @author Team05
 *VoterAction.java
 *com.wipro.evs.action
 *Jan 27, 2014
 */
public class VoterAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ONE=1;
	private static final int THREE=3;
	private static final int ZERO = 0;
	
	private ApplicationBean applicationBean;
	private Map<String, Object> session;
	private String electionID;
	private String candidateID;
	private Date dateOfBirth1;
	private ProfileBean profileBean;

	/**
	 * @return the dateOfBirth1
	 */
	public Date getDateOfBirth1() {
		return dateOfBirth1;
	}

	/**
	 * @param dateOfBirth1
	 *            the dateOfBirth1 to set
	 */
	public void setDateOfBirth1(Date dateOfBirth1) {
		this.dateOfBirth1 = dateOfBirth1;
	}

	/**
	 * @return the profileBean
	 */
	public ProfileBean getProfileBean() {
		return profileBean;
	}

	/**
	 * @param profileBean
	 *            the profileBean to set
	 */
	public void setProfileBean(ProfileBean profileBean) {
		this.profileBean = profileBean;
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
	 * @return the applicationBean
	 */
	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	/**
	 * @param applicationBean
	 *            the applicationBean to set
	 */
	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String requestVoterID() throws SQLException {
		String userId = (String) session.get("name");
		String result = "FAIL";
		VoterImpl voter = new VoterImpl();
		result = voter.requestVoterId(userId);
		session.put("requestResult", result);
		return result;

	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String viewGeneratedVoterID() throws SQLException {
		String userId = (String) session.get("name");
		String constituency = null;
		VoterImpl voter = new VoterImpl();
		ApplicationBean applicationBean1 = new ApplicationBean();
		applicationBean1 = voter.getConstituency(userId);
		constituency = applicationBean1.getConstituency();
		String result = "FAIL";
		String voterID = voter.viewGeneratedVoterId(userId, constituency);
		session.put("voterID", voterID);
		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String supportVoting() throws SQLException {
		String userId = (String) session.get("name");
		ApplicationBean applicationBean1 = new ApplicationBean();
		VoterImpl voter = new VoterImpl();
		applicationBean1 = voter.getConstituency(userId);
		String voterID = applicationBean1.getVoterID();
		String result = null;
		boolean vote = voter.voted(voterID);
		if (vote == true)
		{
			result = "ALREADY CASTED”";
		}
		else {
			applicationBean1 = voter.getConstituency(userId);
			ArrayList<Object> list = new ArrayList<Object>();

			ArrayList<CandidateBean> clist = new ArrayList<CandidateBean>();
			ArrayList<PartyBean> plist = new ArrayList<PartyBean>();
			System.out.println(applicationBean1.getPassedStatus() + " "
					+ applicationBean1.getApprovedStatus());

			String constituency = applicationBean1.getConstituency();
			String electionID1 = voter.getElectionID(constituency);

			if (applicationBean1.getPassedStatus() == THREE
					&& applicationBean1.getApprovedStatus() == ONE) {
				list = voter.supportCastVote(applicationBean1.getConstituency(),
						electionID1);
				int count = 0;
				Iterator<Object> iter = list.iterator();
				while (iter.hasNext()) {
					CandidateBean candidateBean = new CandidateBean();
					PartyBean partyBean = new PartyBean();
					iter.next();
					candidateBean.setElectionID((String) list.get(count++));
					iter.next();
					candidateBean.setCandidateID((String) list.get(count++));
					iter.next();
					candidateBean.setName((String) list.get(count++));
					iter.next();
					candidateBean.setDistrict((String) list.get(count++));
					iter.next();
					candidateBean.setAddress((String) list.get(count++));
					clist.add(candidateBean);
					plist.add(partyBean);
				}
				session.put("CDetails", clist);
				session.put("PDetails", plist);

				result = "SUCCESS";
			}

			else
			{
				result = "VoterID Not Generated";
			}
			String electionID2 = voter.getElectionID(constituency);

			if (applicationBean1.getPassedStatus() != THREE
					|| applicationBean1.getApprovedStatus() != ONE)
			{
				result = "VoterID Not Generated";
			}
			else if (("null").equals(electionID2))
			{
				result = "No Election Today";
			}
			else
			{
				session.put("electionID", electionID2);
			}
		}

		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String castVote() throws SQLException {
		String userId = (String) session.get("name");
		VoterImpl voter = new VoterImpl();
		String electionID1 = (String) session.get("electionID");
		String result = "FAIL";
		voter.castVote(userId, electionID1, candidateID);
		result = "SUCCESS";

		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String viewElectionResults() throws SQLException {
		VoterImpl voter = new VoterImpl();
		ArrayList<ResultBean> list = new ArrayList<ResultBean>();
		list = voter.viewListOfElectionsResults();
		session.put("result", list);
		String result = "SUCCESS";
		if (list.size() ==ZERO )
		{
			result = "NODATA";
		}
		return result;
	}

	/**
	 * @return the result
	 * @throws ParseException DATE OPERATION
	 * @throws SQLException SQL OPERATION
	 */
	public String registerVoter() throws ParseException, SQLException {
		String result = null;
		UserImpl userImpl = new UserImpl();
		profileBean.setDateOfBirth(userImpl.stringToDate(dateOfBirth1));
		System.out.println(profileBean.getDateOfBirth());
		String userid = userImpl.register(profileBean);
		if (("FAIL").equals(userid))
		{
			result = "FAILURE";
		}
		else
		{
			result = "SUCCESS";
		}

		return result;
	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String generatePDFResults() throws SQLException {
		String result = "FAIL";
		VoterImpl voter = new VoterImpl();
		ArrayList<ResultBean> arrRes = new ArrayList<ResultBean>();
		arrRes = voter.viewListOfElectionsResults();
		int size = arrRes.size();
		try {
			FileOutputStream file = new FileOutputStream(
					new File(
							"D:\\Root\\Local\\workspace\\NewWorkSpace\\EVS\\Logs\\ELECTION_RESULT.pdf"));

			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("ELECTION RESULTS"));
			int count = 0;
			while (size > count) {
				document.add(new Paragraph("Election ID .... "
						+ arrRes.get(count).getElectionID()));
				document.add(new Paragraph("Winner .... "
						+ arrRes.get(count).getCandidateID()));
				document.add(new Paragraph("Vote Count .... "
						+ arrRes.get(count).getVoteCount()));
				count += 1;
			}

			document.add(new Paragraph());
			document.add(new Paragraph());

			document.close();
			file.close();

			result = "SUCCESS";

		} catch (Exception e) {

			result = "FAIL";
		}

		return result;
	}

}
