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
<s:property value="%{#session.name}"/><br>

<a href="<s:url action="VoterIDRequestAction" />">Request for voter ID</a><br>
<a href="<s:url action="ViewVoterID" />">VoterID Status</a><br>
<a href="<s:url action="ViewUpcomingElectionByVoterAction" />">View Upcoming Election</a><br>
<a href="<s:url action="CastVoteHelpAction" />">Vote</a><br>
<a href="<s:url action="ElectionByNameVoter" />">View Candidate Details by Election Name</a><br>
<a href="<s:url action="ViewResultAction" />">View Election Results</a><br>

</body>
</html>