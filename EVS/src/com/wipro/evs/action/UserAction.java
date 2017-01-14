package com.wipro.evs.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.UserImpl;

/**
 * @author Team05 LoginAction.java com.wipro.evs.action Jan 23, 2014
 */
public class UserAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CredentialsBean credentialsBean;
	private Map<String, Object> session;
	private String password;
	private String newPassword;
	private String rePassword;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the rePassword
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * @param rePassword
	 *            the rePassword to set
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	/**
	 * @return the credentialsBean
	 */
	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}

	/**
	 * @param credentialsBean
	 *            the credentialsBean to set
	 */
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}

	/**
	 * @return the userType
	 * @throws SQLException SQL OPERATION
	 */
	public String login() throws SQLException

	{
		UserImpl userImpl = new UserImpl();
		String userType = userImpl.login(credentialsBean);
		if (!(("INVALID").equals(userType))) {
			String userId = null;
			String passwd = null;
			userId = credentialsBean.getUserID();
			passwd = credentialsBean.getPassword();
			session.put("name", userId);
			session.put("passwd", passwd);
		}
		return userType;
	}

	/**
	 * @return the status
	 * @throws SQLException SQL OPERATION
	 */
	public String changePassword() throws SQLException {
		String status = "FAIL";
		CredentialsBean credentialsBean1 = new CredentialsBean();
		String pswd = null;
		String userId = (String) session.get("name");

		UserImpl userImpl = new UserImpl();
		pswd = (String) session.get("passwd");
		if (pswd.equals(password)) {
			if (rePassword.equals(newPassword)) {

				credentialsBean1.setPassword(rePassword);
				status = userImpl.changePassword(credentialsBean, userId);
			} else {
				status = "INVALID";
				addFieldError("rePassword", "password mismatch");
			}
		} else {
			status = "INVALID";
			addFieldError("password", "Invalid Password");
		}
		/*
		 * if (status.equals("SUCCESS")) { return "success"; } else return
		 * "failure";
		 */
		return status;

	}

	/**
	 * @return the result
	 * @throws SQLException SQL OPERATION 
	 */
	public String logout() throws SQLException {
		String userId = (String) session.get("name");
		UserImpl user = new UserImpl();
		String result = user.logout(userId);
		session.remove("name");
		session.clear();

		return result;
	}

}
