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
	             <th>Serial Number</th>
	            <th>Election ID</th>
	             <th>Candidate ID</th>
	         <th>Vote Count</th>
	            </tr>
	           
	            <s:iterator id="1" value="#session['result']" >
	            <tr>
	            <td><s:property value="serailNo"/></td>
	            
	          <td><s:property value="electionID"/></td>
	          
	          <td><s:property value="candidateID"/></td>
	          
	          <td><s:property value="voteCount"/></td>
	          
	            </tr>
	         
	            </s:iterator>
	             </table>
	             <center>
	             <s:form action="GeneratePDFAction">
				<s:submit  style="background-color:aqua;height:40px;width:400px;" value="Generate PDF" name="viewall"></s:submit>
				</s:form><br>
				</center>
	             
	             <br><a href="VoterHomePage.jsp">Home Page</a>	         
</body>
