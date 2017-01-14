<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix = "sx" uri = "/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<s:head/>
<body background="bgimg2.jpg">
<sx:head/>
	<center>
		<h1>REGISTER HERE</h1>
	</center>

	<br>
	<br>
	<s:form action="RegisterAction">
		<center>
			<table border="1" cellspacing="4" cellpadding="4" bgcolor="#cccccc">

				<s:textfield name="profileBean.firstName" label="FirstName" />
				<s:textfield name="profileBean.lastName" label="LastName" />




				<tr>
					<td align="center">GENDER</td>
					<td><select name="profileBean.gender" id="gender">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
					</select></td></tr>
					<s:merge>
					<sx:datetimepicker name="dateOfBirth1" label="Date Of Birth" displayFormat="dd-MM-yyyy"  ></sx:datetimepicker>
					</s:merge>
					<s:textfield name="profileBean.street" label="Street" />
					<s:textfield name="profileBean.location" label="Location" />
					<s:textfield name="profileBean.city" label="City" />
					<s:textfield name="profileBean.state" label="State" />
					<s:textfield name="profileBean.pincode" label="Pincode" />
					<s:textfield name="profileBean.mobileNo" label="Mobile Number" />
					<s:textfield name="profileBean.emailID" label="Email ID" />
			</table>
		</center>
		<center>
			<br>
			<br>
			<br>
			<s:submit value="SUBMIT" name="submit" align="center" />
			<s:submit value="RESET" align="center" />
		</center>
	</s:form>

	<br>
	<br>
</body>
</html>