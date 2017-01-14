<%@page import="java.util.ArrayList"%>
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

	<table border='2' cellpadding="25">
		<tr>

			<th>Party ID</th>
			<th>Party Symbol</th>
			<th>Candidate ID</th>
			<th>Candidate Name</th>
			<th>	Vote	</th>
		</tr>



				
				<s:iterator id="1" value="#session['CDetails']" >
	              
	            <tr><td><s:property value="district"/></td>
	            <%-- <td><s:property value="address"/></td> --%>
	            <td><img src="${address}" width="200" height="50" /></td>
	            <td><s:property value="candidateID"/></td>
	            <td><s:property value="name"/></td>
	            <td width="75" height="50"><s:form action="CastVoteAction">
							<s:hidden name="candidateID" value="%{candidateID}" />
							<input type="submit" value="Cast Vote" />
						</s:form></td>
	          </tr>
	            
	         
	            </s:iterator>
					
				
				 





	</table>
	<br><a href="VoterHomePage.jsp">Home Page</a>	

</body>
</html>