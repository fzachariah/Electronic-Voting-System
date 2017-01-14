/**
 * @author Team05
 *UserImpl.java
 *com.wipro.evs.util
 *Jan 22, 2014
 */
package com.wipro.evs.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.dao.CredentialsDAOImpl;
import com.wipro.evs.dao.ProfileDAOImpl;

public class UserImpl extends ActionSupport implements User, SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private boolean validity;
	private String userType;
	private AuthenticationImpl authenticationImpl;

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
	 * @param credentialsBean
	 * @return the userType
	 * @throws SQLException SQL OPERATION
	 */
	@SuppressWarnings("finally")
	public String login(CredentialsBean credentialsBean) throws SQLException {

		try {
			authenticationImpl = new AuthenticationImpl();

			userType = "FAIL";
			validity = authenticationImpl.authenticate(credentialsBean);
			if (validity == true) {
				userType = authenticationImpl.authorize(
						credentialsBean.getUserID(), validity);
				

			} else
			{
				userType = "INVALID";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userType = "FAIL";
		} finally {
			return userType;
		}

	}

	/**
	 * @param userId
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	public String logout(String userId) throws SQLException {
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		credentialsDAOImpl.updateCredentialsStatusLogout(userId);
		
		return "SUCCESS";

	}

	/**
	 * @param credentialsBean
	 * @param userId
	 * @return the string
	 * @throws SQLException SQL OPERATION
	 */
	public String changePassword(CredentialsBean credentialsBean, String userId)
			throws SQLException {
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		String temp = credentialsBean.getPassword();

		credentialsBean = credentialsDAOImpl.findByID(userId);
		credentialsBean.setPassword(temp);
		credentialsBean.setUserID(userId);
		validity = credentialsDAOImpl.updateCredentials(credentialsBean);
		System.out.println(validity);
		if (validity == true)
		{
			return "SUCCESS";
		}
		else
		{
			return "Invalid";
		}
	}

	/**
	 * @param profileBean
	 * @return the userid
	 * @throws SQLException SQL OPERATION
	 */
	public String register(ProfileBean profileBean) throws SQLException {
		CredentialsDAOImpl credentialDAO = new CredentialsDAOImpl();
		String userid = "FAILURE";
		userid = credentialDAO.createCredentials(profileBean);

		profileBean.setUserID(userid);
		ProfileDAOImpl profileDAO = new ProfileDAOImpl();
		profileDAO.createProfile(profileBean);
		return userid;

	}

	/**
	 * @param dateOfBirth1
	 * @return the date
	 * @throws ParseException DATE OPERATION
	 */
	public java.sql.Date stringToDate(Date dateOfBirth1) throws ParseException {
		return (new java.sql.Date(dateOfBirth1.getTime()));
	}

}
