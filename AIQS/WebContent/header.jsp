<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import ="com.aiqs.bean.*, com.aiqs.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<p align="center" style="background-color: skyblue;">
	Auto Insurance Quote System
</p>
<p align="right" style="background-color: pink;">
<%
	AiqsUser user = (AiqsUser)(request.getSession(false)).getAttribute("USER");
	if(user != null){
		if(user instanceof AiqsAdmin){
%>
		<a href="admin_home.jsp">Home</a> |
		<%=user.getUserCredential().getType() %> |
		<%=user.getUserCredential().getName() %> |
		<a href="get_password_update_form.action">CHANGE PASSWORD</a>|
		<a href="Signout.action">SIGN OUT</a>
<%
		}else{
%>
		<a href="user_home.jsp">Home</a> |
		<%=user.getUserCredential().getType() %> |
		<%=user.getUserCredential().getName() %> |
		<a href="get_password_update_form.action">CHANGE PASSWORD</a>|
		<a href="Signout.action">SIGN OUT</a>
<%			
		}
	}else{
%>
	<a href="default.jsp">Home</a> |
	<a href="getInputForm.action">REGISTER NEW USER</a> | 
	<a href="getSigninForm.action">SIGN UP</a>
<%
	}
%>
</p>