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

<s:form action="AdminApproveAction" >
<table border='2' cellpadding="25">
<tr>
	             <th>UserID</th>
	          <th>Constituency</th>
	          <th>Approve</th>
	            </tr>
	           
	            <s:iterator id="1" value="#session['VoterIDRequest']" >
	              
	            <tr><td><s:property value="userID"/></td>
	            
	          <td><s:property value="constituency"/></td>
	          <td><s:checkbox name="userID" theme="simple" fieldValue="%{userID}"></s:checkbox></td>
	          </tr>
	            
	         
	            </s:iterator>
	            
	             </table>
	             <td> <input type="submit" value="Approve"/></td></s:form>
	             <br><a href="ViewDetails.jsp">Back</a>  
</body>
</html>