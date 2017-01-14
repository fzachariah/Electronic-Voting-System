/**
 * @author Team05
 *PartyDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.util.DBUtilImpl;

public class PartyDAOImpl implements PartyDAO {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int ZERO = 0;
	private Connection con;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private ResultSet rs;

	/**
	 * @param partyBean PARAMETER
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createParty(PartyBean partyBean) throws SQLException {
		// TODO Auto-generated method stub
		int sequence = 0;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst1 = con.prepareStatement("select evs_seq_partyId.nextval from dual");
		rs = pst1.executeQuery();
		while (rs.next()) {
			sequence = rs.getInt(ONE);
		}
		String name = partyBean.getName().substring(ZERO, TWO);
		partyBean.setPartyID(name + sequence);
		pst = con.prepareStatement("insert into EVS_TBL_party values(?,?,?,?)");
		pst.setString(ONE, partyBean.getPartyID());
		pst.setString(TWO, partyBean.getName());
		pst.setString(THREE, partyBean.getLeader());
		pst.setString(FOUR, partyBean.getSymbol());
		int count = pst.executeUpdate();

		con.commit();
		String result = "null";
		if (count == 1) {
			result = "SUCCESS";
		} else if (count == 0) {
			result = "FAIL";
		} else {
			result = "ERROR";
		}
		return result;
	}

	


	/**
	 * @return the list PARAMETER
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<PartyBean> findAll() throws SQLException {
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con.prepareStatement("select * from EVS_TBL_Party");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<PartyBean> list= new ArrayList<PartyBean>();
	
		while (rs.next()) {
			PartyBean partyBean = new PartyBean();
			partyBean.setPartyID(rs.getString(ONE));
			partyBean.setName(rs.getString(TWO));
			partyBean.setLeader(rs.getString(THREE));
			partyBean.setSymbol(rs.getString(FOUR));
			list.add(partyBean);
		}
		return list;
	}

}
