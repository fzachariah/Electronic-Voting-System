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

	<table border='2' >

		<tr>
			<th>Party ID</th>
			<th>Party Name</th>
			<th>Leader</th>
			<th>Symbol</th>
			<th>View Candidates</th>
		</tr>

		<s:iterator id="1" value="#session['PartyDetails']">
			<tr>
				<td><s:property value="partyID" /></td>

				<td><s:property value="name" /></td>

				<td><s:property value="leader" /></td>

				<%--     <td><s:property value="symbol"/><s:</td> --%>
				<td><img src="${symbol}" width="200" height="50" /></td>


				<td width="150"><s:form action="ViewCandidate-Party">
						<s:hidden name="partyID" value="%{partyID}" />
						<input type="submit" value="View Candidates" />
					</s:form></td>
			</tr>

		</s:iterator>
	</table>

<br><a href="ViewDetails.jsp">Back</a>

</body>
</html>