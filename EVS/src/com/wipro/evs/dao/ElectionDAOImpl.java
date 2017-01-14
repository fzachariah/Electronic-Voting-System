/**
 * @author Team05
 *ElectionDAOImpl.java
 *com.wipro.evs.dao
 *Jan 22, 2014
 */
package com.wipro.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.util.DBUtilImpl;

public class ElectionDAOImpl implements ElectionDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int ZERO = 0;
	private Connection con;

	/**
	 * @param electionBean PARAMETER
	 * @return the result
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public String createElection(ElectionBean electionBean) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst;
		PreparedStatement pst1;
		ResultSet rs;
		int sequence = 0;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst1 = con
				.prepareStatement("select evs_seq_electionId.nextval from dual");
		rs = pst1.executeQuery();
		while (rs.next()) {
			sequence = rs.getInt(ONE);
		}
		String name = electionBean.getName().substring(ZERO, TWO);
		electionBean.setElectionID(name + sequence);
		pst = con
				.prepareStatement("insert into EVS_TBL_Election values(?,?,?,?,?,?)");
		pst.setString(ONE, electionBean.getElectionID());
		pst.setString(TWO, electionBean.getName());
		pst.setDate(THREE, electionBean.getElectionDate());
		pst.setString(FOUR, electionBean.getDistrict());
		pst.setString(FIVE, electionBean.getConstituency());
		pst.setDate(SIX, electionBean.getCountingDate());
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
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<ElectionBean> findUpcoming() throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Election where electiondate>sysdate");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<ElectionBean> list= new ArrayList<ElectionBean>();
		while (rs.next()) {
			ElectionBean electionBean = new ElectionBean();
			electionBean.setElectionID(rs.getString(ONE));
			electionBean.setName(rs.getString(TWO));

			java.util.Date utilDate = new java.util.Date();
			utilDate = rs.getDate(THREE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			electionBean.setElectionDate(sqlDate);

			electionBean.setDistrict(rs.getString(FOUR));
			electionBean.setConstituency(rs.getString(FIVE));

			java.util.Date utilDate1 = new java.util.Date();
			utilDate1 = rs.getDate(SIX);
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			electionBean.setCountingDate(sqlDate1);
			System.out.println(electionBean.getCountingDate());
			list.add(electionBean);
		}
		return list;
	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	@Override
	public ArrayList<ElectionBean> findAll() throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con.prepareStatement("select * from EVS_TBL_Election");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<ElectionBean> list= new ArrayList<ElectionBean>();
		while (rs.next()) {
			ElectionBean electionBean = new ElectionBean();
			electionBean.setElectionID(rs.getString(ONE));
			electionBean.setName(rs.getString(TWO));

			java.util.Date utilDate = new java.util.Date();
			utilDate = rs.getDate(THREE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			electionBean.setElectionDate(sqlDate);

			electionBean.setDistrict(rs.getString(FOUR));
			electionBean.setConstituency(rs.getString(FIVE));

			java.util.Date utilDate1 = new java.util.Date();
			utilDate1 = rs.getDate(SIX);
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			electionBean.setCountingDate(sqlDate1);
			System.out.println(electionBean.getCountingDate());
			list.add(electionBean);
		}
		return list;
	}

	/**
	 * @param constituency PARAMETER
	 * @return the electionID
	 * @throws SQLException SQL OPERATION
	 */
	public String electionDate(String constituency) throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con
				.prepareStatement("select * from EVS_TBL_Election where electiondate=to_date(sysdate,'DD-MM-YY') and constituency='"
						+ constituency + "'");
		rs = pst.executeQuery();
		con.commit();
		String electionID = "null";
		while (rs.next()) {
			electionID = rs.getString(ONE);
			System.out.println("here");
		}
		return electionID;
	}

	/**
	 * @return the list
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<ElectionBean> getelectionDate() throws SQLException {
		PreparedStatement pst;
		PreparedStatement pst1;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();

		pst = con
				.prepareStatement("select count(EVS_TBL_Result.electionId) from EVS_TBL_Result inner join EVS_TBL_Election on EVS_TBL_Result.electionId=EVS_TBL_Election.electionid where EVS_TBL_Election.countingdate = (to_date(sysdate,'DD-MM-YY'))");
		rs = pst.executeQuery();
		int size = 0;
		while (rs.next()) {
			size = rs.getInt(ONE);
		}

		pst = con
				.prepareStatement("select EVS_TBL_Result.electionId from EVS_TBL_Result inner join EVS_TBL_Election on EVS_TBL_Result.electionId=EVS_TBL_Election.electionid where EVS_TBL_Election.countingdate = (to_date(sysdate,'DD-MM-YY'))");
		rs = pst.executeQuery();
		String electionID[] = new String[size];
		int count = 0;
		while (rs.next()) {
			electionID[count++] = rs.getString(ONE);
		}
		pst1 = con
				.prepareStatement("select * from EVS_TBL_Election where countingdate=to_date(sysdate,'DD-MM-YY')");
		rs = pst1.executeQuery();
		con.commit();
		ArrayList<ElectionBean> list = new ArrayList<ElectionBean>();
		while (rs.next()) {
			int temp = 0;
			for (int i = 0; i < size; i++) {
				if (electionID[i].equals(rs.getString(ONE)))

				{
					temp++;
					break;
				}
			}
			if (temp == 0) {
				ElectionBean electionBean = new ElectionBean();
				electionBean.setElectionID(rs.getString(ONE));
				electionBean.setName(rs.getString(TWO));

				java.util.Date utilDate = new java.util.Date();
				utilDate = rs.getDate(THREE);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				electionBean.setElectionDate(sqlDate);

				electionBean.setDistrict(rs.getString(FOUR));
				electionBean.setConstituency(rs.getString(FIVE));

				java.util.Date utilDate1 = new java.util.Date();
				utilDate1 = rs.getDate(SIX);
				java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
				electionBean.setCountingDate(sqlDate1);
				System.out.println(electionBean.getCountingDate());
				list.add(electionBean);
			}
		}
		return list;
	}

	/**
	 * @return the electionName
	 * @throws SQLException SQL OPERATION
	 */
	public ArrayList<String> electionName() throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		DBUtilImpl dbUtil = new DBUtilImpl();
		con = dbUtil.getDBConnection();
		pst = con.prepareStatement("select name from EVS_TBL_Election");
		rs = pst.executeQuery();
		con.commit();
		ArrayList<String> electionName = new ArrayList<String>();
		while (rs.next()) {
			electionName.add(rs.getString(ONE));
		}

		return electionName;

	}

}
