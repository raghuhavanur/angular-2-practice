<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIQS</title>
<sx:head/>
</head>
<body>
<s:include value="header.jsp" />
USER HOME
<br><br>
<a href="BuyInsuranceQuote.jsp">Buy Insurance Quote</a><br><br>
<a href="getDriverList.action">Manage Your Driver</a><br><br>
<a href="QuoteById.jsp">View Your Quote</a><br><br>
<br><br>
<s:if test="hasActionErrors()">
	<div class="errors">
    		<s:actionerror/>
  	</div>
</s:if>
<s:if test="hasActionMessages()"> 
	<div class="displayMessage">
   		<s:actionmessage/>
	</div>
</s:if>
<br><br><br><br><br><br>
<s:include value="footer.jsp" />
</body>
</html>