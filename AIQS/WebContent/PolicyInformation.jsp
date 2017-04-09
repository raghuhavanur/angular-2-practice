<%@page import="java.util.Date"%>
<%@page import="com.aiqs.bean.*, com.aiqs.domain.*"%>
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
<s:form action="payment">
	<%
	QuoteBean biq=(QuoteBean)request.getAttribute("Quote"); %>

<table border=0>
<tr>
<td>User-Id</td><td>:<%=biq.getUserId()%></td></tr>
<tr>
<td>Quote Id</td><td>:<%=biq.getQuoteId()%></td></tr>
<tr>
<td>Policy Type</td><td>:<%=biq.getPolicyType()%></td></tr>
<tr>
<td>Policy Start Date</td><td>:<%=biq.getPolicyStartDate()%></td></tr>
<tr>
<td>Vehicle Make</td><td>:<%=biq.getVehicleMake()%></td></tr>
<tr>
<td>Vehicle Model</td><td>:<%=biq.getVehicleModel()%></td></tr>
<tr>
<td>Year Of Manufacture</td><td>:<%=biq.getManufactureYear()%></td></tr>
<tr>
<td>Registration Date</td><td>:<%=biq.getRegistrationDate()%></td></tr>
<tr>
<td>Registration State</td><td>:<%=biq.getRegistrationState()%></td></tr>
<tr>
<td>Registration City</td><td>:<%=biq.getRegistrationCity()%></td></tr>
<tr>
<td>Fuel Type</td><td>:<%=biq.getFuelType()%></td></tr>
<tr>
<td>ShowRoom Price</td><td>:<%=biq.getShowroomPrice()%></td></tr>
<tr>
<td>DOB of Owner</td><td>:<%=biq.getDobOfOwner()%></td></tr>
<tr>
<td>Profession</td><td>:<%=biq.getProfessionOfOwner()%></td></tr>
<tr>
<td>Insurance Provider</td><td>:<%=biq.getInsuranceProvider()%></td></tr>
<tr>
<td>Premium Amount</td><td>:<%=biq.getPremiumAmount()%></td></tr>
<tr>
<td>Engine Number</td><td>:<%=biq.getEngineNumber()%></td></tr>
<tr>
<td>Chassis Number</td><td>:<%=biq.getChassisNumber()%></td></tr>
<tr>
<td>PAN Number</td><td>:<%=biq.getPanNumber()%></td></tr>
<tr>
<td>Mailing Address</td><td>:<%=biq.getMailingAddress()%></td></tr>
<tr>
<td>Payment Mode</td><td>:<%=biq.getPaymentMode()%></td></tr>
<tr><td>

</td></tr>
</table>
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
<s:include value="footer.jsp" />
</s:form>
</body>
</html>