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
<s:head/>
</head>
<body>

<s:include value="header.jsp" />
	<s:form action="subPay" method="post" name="fr">
	<s:textfield label ="Engine Number" name ="biq.engineNumber" />
	<s:textfield label ="Chassis Number" name ="biq.chassisNumber" />
	<s:textfield label ="PAN Number" name ="biq.panNumber" />
	<s:textarea  label ="Mailing-Address" name ="biq.mailingAddr" />
	<s:radio label ="Payment-Mode" name ="biq.paymentMode" list="{'Cheque','Credit-Card'}"/>
	<s:submit name="Submit" value="Submit"></s:submit>
	

</s:form>
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

</body>
</html>