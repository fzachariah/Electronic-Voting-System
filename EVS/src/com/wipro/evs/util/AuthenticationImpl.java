package com.wipro.evs.util;

import java.sql.SQLException;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.dao.CredentialsDAOImpl;

/**
 * @author Team05 AuthenticationImpl.java com.wipro.evs.util Jan 22, 2014
 */
public class AuthenticationImpl implements Authentication {

	/**
	 * @param user
	 * @return the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean authenticate(CredentialsBean user) throws SQLException {
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		CredentialsBean credentialBean = credentialsDAOImpl.findByID(user
				.getUserID());
		int loginStatus = 0;
		if (credentialBean.getUserID().equals(user.getUserID())
				&& credentialBean.getPassword().equals(user.getPassword())) {
			loginStatus = 1;
			changeLoginStatus(credentialBean, loginStatus);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param userId
	 * @param validity
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	public String authorize(String userId, boolean validity)
			throws SQLException {
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		CredentialsBean credentialBean = credentialsDAOImpl.findByID(userId);

		String result = "FAIL";
		result = credentialBean.getUserType();
		return result;

	}

	/**
	 * @param user
	 * @param loginStatus
	 * @return  the boolean
	 * @throws SQLException SQL OPERATION
	 */
	public boolean changeLoginStatus(CredentialsBean user, int loginStatus)
			throws SQLException {
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		CredentialsBean credentialBean = credentialsDAOImpl.findByID(user
				.getUserID());
		credentialBean.setLoginStatus(loginStatus);
		credentialsDAOImpl.updateCredentialsStatus(credentialBean);
		return true;

	}
}
