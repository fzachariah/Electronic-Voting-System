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
<body background="bgimg2.jpg">
	<center>
		<h1>Party Details</h1>
	</center>

	<br>
	<br>
	<s:form action="PartyAction">
		<center>
			<table border="1" cellspacing="4" cellpadding="4" bgcolor="#cccccc">
				<s:textfield name="partyBean.name" label="Party Name" />
				
				<s:textfield name="partyBean.leader" label="Leader Name" />
				<s:file label="Party Symbol" name="partyBean.symbol"></s:file>				

			</table>
			<s:submit value="SUBMIT" name="submit" align="center" />
		</center>
	</s:form>

</body>
</html>