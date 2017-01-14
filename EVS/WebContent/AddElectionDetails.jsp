<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix = "sx" uri = "/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<sx:head/>
<body background="bgimg2.jpg">

	<center>
		<h1>REGISTER HERE</h1>
	</center>

	<br>
	<br>
	<s:form action="ElectionAction">
		<center>
			<table border="1" cellspacing="4" cellpadding="4" bgcolor="#cccccc">
				<s:textfield name="electionBean.name" label="Election Name" />
				<s:merge>
					<sx:datetimepicker  label="Election Date" name="electionDate"  displayFormat="dd-MM-yyyy"  ></sx:datetimepicker>
				</s:merge>
				<s:textfield name="electionBean.district" label="District" />
				<s:textfield name="electionBean.constituency" label="Constituency" />
				<s:merge>
					<sx:datetimepicker   name="countingDate"  displayFormat="dd-MM-yyyy" label="Counting Date" ></sx:datetimepicker>
					
				</s:merge>
				

			</table>
			<s:submit value="SUBMIT" name="submit" align="center" />
		</center>
	</s:form>

</body>
</html>