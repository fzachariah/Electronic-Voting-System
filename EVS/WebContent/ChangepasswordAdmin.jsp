<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<s:head/>
<body>
	<center>


		<s:form action="ChangeAction">
		<s:actionerror/>
			<table>


				<tr>
					<td><s:actionerror/><s:password label="Enter your password" name="password"></s:password></td>
				</tr>
				<tr>
					<td><s:actionerror/><s:password label=" New Password" name="newPassword"></s:password></td>
				</tr>
				<tr>
					<td><s:actionerror/><s:password label=" Retype Password" name="rePassword"></s:password></td>
				</tr>
				<tr>
					<td><s:submit value="Change"></s:submit></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>