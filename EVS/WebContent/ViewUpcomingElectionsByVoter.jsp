<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Records</title>
</head>
<body>

	<table border='2'>
		<tr>
			<th>Election ID</th>
			<th>Name</th>
			<th>Election Date</th>
			<th>District</th>
			<th>Constituency</th>
			<th>Counting Date</th>
			<th>View Candidates</th>
		</tr>

		<s:iterator id="1" value="#session['UpcomingElectionDetails']">
			<tr>
				<td><s:property value="electionID" /></td>

				<td><s:property value="name" /></td>

				<td><s:property value="electionDate" /></td>

				<td><s:property value="district" /></td>

				<td><s:property value="constituency" /></td>

				<td><s:property value="countingDate" /></td>

				<td width="150" height="50"><s:form action="ViewCandidate-Election">
						<s:hidden name="electionID" value="%{electionID}" />
						<input type="submit" value="View Candidates" />
					</s:form></td>
			</tr>

		</s:iterator>
	</table>

<br><a href="VoterHomePage.jsp">Home Page</a>

</body>
</html>