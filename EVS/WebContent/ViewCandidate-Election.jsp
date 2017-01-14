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
			<th>Candidate ID</th>
			<th>Candidate Name</th>
			<th>Election ID</th>
			<th>Party ID</th>
			<th>District</th>
			<th>Constituency</th>
			<th>Date of Birth</th>
			<th>Mobile No</th>
			<th>Address</th>
			<th>Email ID</th>
		</tr>

		<s:iterator id="1" value="#session['CandidateDetails-Election']">
			<tr>
				<td><s:property value="candidateID" /></td>

				<td><s:property value="name" /></td>

				<td><s:property value="electionID" /></td>

				<td><s:property value="partyID" /></td>

				<td><s:property value="district" /></td>

				<td><s:property value="constituency" /></td>
				
				<td><s:property value="dateOfBirth" /></td>
				
				<td><s:property value="mobileNo" /></td>
				
				<td><s:property value="address" /></td>
				
				<td><s:property value="emailID" /></td>
			</tr>

		</s:iterator>
	</table>

<br><a href="ViewElectionByName.jsp">Back</a> 

</body>
</html>