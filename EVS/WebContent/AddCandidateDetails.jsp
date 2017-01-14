<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix = "sx" uri = "/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bgimg2.jpg">
<sx:head/>
	<center>
		<h1>REGISTER HERE</h1>
	</center>

	<br>
	<br>
	<% String hidden = request.getParameter("electionID1"); %>
	<% String hidden1 = request.getParameter("district1"); %>
	<% String hidden2 = request.getParameter("constituency1"); %>
				
	<s:form action="AddCandidateAction">
		<center>
			<table border="1" cellspacing="4" cellpadding="4" bgcolor="#cccccc">
				<s:textfield name="candidateBean.name" label="Candidate Name" />
				<tr><td>ElectionID<td>
				<input type="text" name="candidateBean.electionID" value="<%=hidden %>"/></td></tr>
				
				<%@ page import="com.wipro.evs.dao.CandidateDAOImpl" %>
				<%@ page import="java.util.ArrayList" %>
				<%CandidateDAOImpl candidateDAO=new CandidateDAOImpl();
				ArrayList<String> partyID=new ArrayList<String>();
				partyID=candidateDAO.partyIDList();
				 request.setAttribute("partyID", partyID);
				%>
				
					<tr>
					<td align="center">Party ID</td>
					<td><select name="candidateBean.partyID">
							<c:forEach var="item" items="${partyID}">
           					 <option value="${item}">${item}</option>
          					</c:forEach>

					</select></td></tr>
					
				<tr><td>District<td>
				<input type="text" name="candidateBean.district" value="<%=hidden1 %>"/></td></tr>
				<tr><td>Constituency<td>
				<input type="text" name="candidateBean.constituency" value="<%=hidden2 %>"/></td></tr>
				<s:merge>
					<sx:datetimepicker name="dateOfBirth" label="Date Of Birth" displayFormat="dd-MM-yyyy"  ></sx:datetimepicker>
					</s:merge>
				
				<s:textfield name="candidateBean.mobileNo" label="Mobile No." />
				<s:textfield name="candidateBean.emailID" label="Email" />
				<s:textfield name="candidateBean.address" label="Address" />
				

			</table>
			<s:submit value="SUBMIT" name="submit" align="center" />
			<s:submit value="RESET" align="center" />
		</center>
	</s:form>

</body>
</html>