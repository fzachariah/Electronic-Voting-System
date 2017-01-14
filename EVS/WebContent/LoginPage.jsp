<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>EVS Login Page</title>
</head>
<s:head />

<body background="bgimg.jpg">
	<center>
		<s:form action="UserAction">
			<table>
				<tr>
					<td><s:textfield label="Username"
							name="credentialsBean.userID"></s:textfield></td>
				</tr>
				<tr>
					<td><s:password label="Password"
							name="credentialsBean.password"></s:password></td>
				</tr>
				<tr>
					<td><s:submit value="LOGIN"></s:submit></td>
				</tr>

			</table>
		</s:form>
	</center>

	<a href="registerUser.jsp">New User?Register Here</a>





</body>
</html>