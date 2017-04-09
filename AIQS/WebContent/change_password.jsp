<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sx:head/>
<title>AIQS</title>
</head>
<body>
<s:include value="header.jsp" />
<center>
<s:form action="change_password" method="post">
   <s:password label ="OLD PASSWORD" name ="OldPassword" required="true"/>
   <s:password label ="NEW PASSWORD" name ="NewPassword" required="true"/>
   <s:password label ="CONFIRM NEW PASSWORD" name ="ConfirmPassword" required="true"/>
   <s:submit value="Change Password" name="submit"></s:submit>
</s:form>
</center>
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