/**
 * @author Team05
 *User.java
 *com.wipro.evs.util
 *Jan 22, 2014
 */
package com.wipro.evs.util;

import java.sql.SQLException;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;

interface User {
	String login(CredentialsBean credentialsBean) throws SQLException;

	String logout(String userId) throws SQLException;

	String changePassword(CredentialsBean credentialsBean, String userId)
			throws SQLException;

	String register(ProfileBean profileBean) throws SQLException;

}
