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
	           <th>Approve Results</th>
	            </tr>
	           
	            <s:iterator id="1" value="#session['ElectionResult']" >
	            <tr>
	            <td><s:property value="electionID"/></td>
	            
	          <td><s:property value="name"/></td>
	          
	          <td><s:property value="electionDate"/></td>
	          
	          <td><s:property value="district"/></td>
	          
	           <td><s:property value="constituency"/></td>
	          
	          <td><s:property value="countingDate"/></td>
	          
	          <td><s:form action="AdminApproveResultAction" >
	            <s:hidden name="electionID1" value="%{electionID}"/>
	          <input type="submit" value="Approve"/></s:form></td>
	          
	            </tr>
	         
	            </s:iterator>
	             </table>
	             
	             <input type="button" value="Home Page" style="background-color:gray;height:30px;width:100px;" onclick="window.location = 'welcome.jsp';">
	             
</body>
</html>