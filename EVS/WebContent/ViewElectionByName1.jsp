<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
     <%@taglib uri="/struts-dojo-tags" prefix="sx"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bgimg2.jpg">
<sx:head/>
<s:form action="ViewElectionByNameActionVoter">
<s:merge>
<sx:autocompleter size="1" name="electionName" list="electionName1" showDownArrow="false" label="Election Name"></sx:autocompleter>  
</s:merge>
<s:submit  style="background-color:aqua;height:40px;width:200px;" value="View Election By Name" name="viewall"></s:submit>
</s:form><br>
</body>
</html>