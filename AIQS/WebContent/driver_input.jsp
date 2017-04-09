<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import ="com.aiqs.bean.*, com.aiqs.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sx:head/>
<title>AIQS</title>
</head>
<body>
<s:include value="header.jsp" />
<%
	String Mode=(String)request.getAttribute("MODE");
	if(Mode != null){
		
%>
	<s:form action="updateDriver" method="post">
	<s:textfield label="USER ID" name="DriverDetails.userId" value="%{#session.USER.UserCredential.userId}" readonly="true"/>
	<s:textfield label ="QUOTE ID" name ="DriverDetails.quoteId" required="true"  readonly="true"/>
	<s:textfield label ="FIRST NAME" name ="DriverDetails.firstName" required="true" />
	<s:textfield label ="LAST NAME" name ="DriverDetails.lastName" required="true" />
	<s:textfield label="AGE" name ="DriverDetails.age"  required="true"/>
	<s:radio list="{'MALE','FEMALE'}" label="GENDER" name="DriverDetails.gender" required="true"></s:radio>
	<s:textfield label ="PHONE NUMBER" name ="DriverDetails.phoneNo" required="true" />
	<s:textarea  label ="ADDRESS" name ="DriverDetails.address" required="true"/>
	<s:textfield label ="E-MAIL" name ="DriverDetails.emailId" required="true"/>
	<s:textfield label="DRIVER ID" name="DriverDetails.driverId" readonly="true"/>
	<s:submit name="submit" value="UPDATE"/>
	</s:form>
<%
	}else{
%>
	<s:form action="saveNewDriver" method="post">
	<s:textfield label="USER ID" name="DriverDetails.userId" value="%{#session.USER.UserCredential.userId}" readonly="true"/>
	<s:textfield label ="QUOTE ID" name ="DriverDetails.quoteId" required="true" />
	<s:textfield label ="FIRST NAME" name ="DriverDetails.firstName" required="true" />
	<s:textfield label ="LAST NAME" name ="DriverDetails.lastName" required="true" />
	<s:textfield label="AGE" name ="DriverDetails.age"  required="true"/>
	<s:radio list="{'MALE','FEMALE'}" label="GENDER" name="DriverDetails.gender" required="true"></s:radio>
	<s:textfield label ="PHONE NUMBER" name ="DriverDetails.phoneNo" required="true" />
	<s:textarea  label ="ADDRESS" name ="DriverDetails.address" required="true"/>
	<s:textfield label ="E-MAIL" name ="DriverDetails.emailId" required="true"/>
	<s:submit name="submit" value="ADD DRIVER"/>
	</s:form>
<%
	}
%>
	
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