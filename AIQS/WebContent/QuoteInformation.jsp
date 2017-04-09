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
	String uid = (String)(request.getSession(false)).getAttribute("Userid");
	String qid = (String)(request.getSession(false)).getAttribute("quoteid");
	String pt = (String)(request.getSession(false)).getAttribute("PolicyType");
	Date psd = (Date)(request.getSession(false)).getAttribute("PolStartDate");
	String vm = (String)(request.getSession(false)).getAttribute("VehicleMake");
	String vmd = (String)(request.getSession(false)).getAttribute("VehicleModel");
	int ym = (Integer)(request.getSession(false)).getAttribute("Yom");
	Date regd = (Date)(request.getSession(false)).getAttribute("RegDate");
	String regs = (String)(request.getSession(false)).getAttribute("RegState");
	String regc = (String)(request.getSession(false)).getAttribute("RegCity");
	String ft = (String)(request.getSession(false)).getAttribute("FuelType");
	int srp = (Integer)(request.getSession(false)).getAttribute("ShowRoomPrice");
	Date dobo = (Date)(request.getSession(false)).getAttribute("DobOwer");
	String pf = (String)(request.getSession(false)).getAttribute("Profession");
	String isp = (String)(request.getSession(false)).getAttribute("InsProvider");
	int pmt = (Integer)(request.getSession(false)).getAttribute("PrmAmt");
	String en = (String)(request.getSession(false)).getAttribute("EngineNumber");
	String chn = (String)(request.getSession(false)).getAttribute("ChassisNumber");
	String pan = (String)(request.getSession(false)).getAttribute("PANNumber");
	String madd = (String)(request.getSession(false)).getAttribute("MailingAddress");
	String paym = (String)(request.getSession(false)).getAttribute("PaymentMode");
%>
<table border=0>
<tr>
<td>User-Id</td><td>:<%=uid%></td></tr>
<tr>
<td>Quote Id</td><td>:<%=qid%></td></tr>
<tr>
<td>Policy Type</td><td>:<%=pt%></td></tr>
<tr>
<td>Policy Start Date</td><td>:<%=psd%></td></tr>
<tr>
<td>Vehicle Make</td><td>:<%=vm%></td></tr>
<tr>
<td>Vehicle Model</td><td>:<%=vmd%></td></tr>
<tr>
<td>Year Of Manufacture</td><td>:<%=ym%></td></tr>
<tr>
<td>Registration Date</td><td>:<%=regd%></td></tr>
<tr>
<td>Registration State</td><td>:<%=regs%></td></tr>
<tr>
<td>Registration City</td><td>:<%=regc%></td></tr>
<tr>
<td>Fuel Type</td><td>:<%=ft%></td></tr>
<tr>
<td>ShowRoom Price</td><td>:<%=srp%></td></tr>
<tr>
<td>DOB of Owner</td><td>:<%=dobo%></td></tr>
<tr>
<td>Profession</td><td>:<%=pf%></td></tr>
<tr>
<td>Insurance Provider</td><td>:<%=isp%></td></tr>
<tr>
<td>Premium Amount</td><td>:<%=pmt%></td></tr>
<tr>
<td>Engine Number</td><td>:<%=en%></td></tr>
<tr>
<td>Chassis Number</td><td>:<%=chn%></td></tr>
<tr>
<td>PAN Number</td><td>:<%=pan%></td></tr>
<tr>
<td>Mailing Address</td><td>:<%=madd%></td></tr>
<tr>
<td>Payment Mode</td><td>:<%=paym%></td></tr>
<tr><td>
<s:submit name="submit" value="Proceed"/>
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