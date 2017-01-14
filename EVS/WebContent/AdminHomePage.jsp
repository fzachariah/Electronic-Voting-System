<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminHomePage</title>
</head>
<s:head />
<body background="bgimg2.jpg">

	<%
		String ses = (String) session.getAttribute("name");
	if (ses == null) {
	%>
	<jsp:forward page="LoginPage.jsp"></jsp:forward>
	<%
		} else {
			out.println("hai");
		}
	%>

	<s:property value="%{#session.name}" /><br>
	
		<a href="AddElectionDetails.jsp">Add Election Details</a>
	
	<br>
	
		<a href="AddPartyDetails.jsp">Add Party Details</a>

	<br>
	
		<a href="ViewDetails.jsp">View Details</a>
	
	<br>
	<%@ page import="com.wipro.evs.bean.ElectionBean"%>
	<%@ page import="com.wipro.evs.action.AdministratorAction"%>
	<%@ page import="com.wipro.evs.dao.ElectionDAOImpl"%>
	<%@ page import="java.util.*"%>
	<%
		ElectionDAOImpl electionDAO = new ElectionDAOImpl();
		ArrayList<ElectionBean> list;
		list = new ArrayList<ElectionBean>();
		list = electionDAO.getelectionDate();

		if (!(list.size() == 0)) {
	%>
	
	<a href="<s:url action="ApproveResults" />">Approve Results</a><br>
	<%
		session.setAttribute("ElectionResult", list);
		} else {
			out.println("NO Elections Today");
		}
	%><br>
	
<a href="ChangepasswordAdmin.jsp">Change Password</a><br>

<a href="<s:url action="LogoutAction" />">Logout</a><br>

</body>
</html>