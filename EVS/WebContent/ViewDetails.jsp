<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>View Election Details</p><br>

<a href="<s:url action="ViewAllElectionAction" />">View All Election</a><br>

<a href="<s:url action="ViewUpcomingElectionAction" />">View Upcoming Election</a><br>

<a href="<s:url action="ViewPartyAction" />">View Party Details</a><br>

<a href="<s:url action="ViewVoterIDRequestAction" />">View Voter ID Request</a><br>

<a href="<s:url action="ElectionByName" />">View Candidate Details by Election Name</a><br>

</body>
</html>