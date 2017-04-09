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
	<s:form action="register_user" method="post">
	<s:textfield label ="FIRST NAME" name ="NewUser.firstName" required="true"/>
	<s:textfield label ="LAST NAME" name ="NewUser.lastName" required="true"/>
	<s:textfield label="AGE" name ="NewUser.age"  required="true"/>
	<s:radio list="{'MALE','FEMALE'}" name="NewUser.gender" label="GENDER" required="true"></s:radio>
	<s:textarea  label ="ADDRESS" name ="NewUser.address" required="true"/>
	<s:textfield label ="E-MAIL" name ="NewUser.emailId" required="true"/>
	<s:textfield label ="PHONE NUMBER" name ="NewUser.phoneNo" required="true"/>
	<s:password label ="PASSWORD" name ="NewUser.password" required="true"/>
	<s:password label ="CONFIRM PASSWORD" name ="NewUser.rtp" required="true"/>
	<s:submit name="submit" value="REGISTER"/>
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
<br><br><br><br><br><br>
<s:include value="footer.jsp" />

</body>
</html>