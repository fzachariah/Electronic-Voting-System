package com.wipro.evs.bean;

/**
 * @author Team05 CredentialsBean.java com.wipro.evs.bean Jan 22, 2014
 */
public class CredentialsBean {
	private String userID;
	private String password;
	private String userType;
	private int loginStatus;

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
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the loginStatus
	 */
	public int getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus
	 *            the loginStatus to set
	 */
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
