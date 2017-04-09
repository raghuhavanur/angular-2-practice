<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import ="com.aiqs.bean.*, com.aiqs.domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function add(){
	document.driver_manager.action="addDriver.action";
	document.driver_manager.submit();
}
function getDetails(val){
	document.driver_manager.action="getTheDriverDetails.action?driver_id="+val;
	document.driver_manager.submit();
}

function del(val){
	document.driver_manager.action="deleteDriver.action?driver_id="+val;
	document.driver_manager.submit();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIQS</title>
</head>
<body>
<s:include value="header.jsp"/>
<center>
<form name ="driver_manager" action ="update_details" method="post">
<table border='3' align="center">
	<tr>
		<td colspan"9"></td>
		<td><a href="javascript:add()">Add New Driver</a></td>
	</tr>
	<tr>
		<th>EDIT</th>
		<th>DriverID</th>
		<th>UserID</th>
		<th>QuoteID</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Age</th>
		<th>Gender</th>
		<th>PhoneNO</th>
		<th>Address</th>
		<th>EmailID</th>
		<th>DELETE</th>
	</tr>
<% 
	ArrayList<DriverBean> dList=(ArrayList<DriverBean>)request.getAttribute("DRIVER"); 
	if(dList != null){
%>
<%
	
	Iterator<DriverBean> itrDlist = dList.iterator();
	while(itrDlist.hasNext()){
		DriverBean driver= itrDlist.next();
%>
	<tr>
		<td><a href="javascript:getDetails('<%=driver.getDriverId()%>')">Edit</a></td>
		<td><%=driver.getDriverId() %></td>
		<td><%=driver.getUserId() %></td>
		<td><%=driver.getQuoteId() %></td>
		<td><%=driver.getFirstName() %></td>
		<td><%=driver.getLastName() %></td>
		<td><%=driver.getAge()%></td>
		<td><%=driver.getGender() %></td>
		<td><%=driver.getPhoneNo() %></td>
		<td><%=driver.getAddress() %></td>
		<td><%=driver.getEmailId() %></td>
		<td><a href="javascript:del('<%=driver.getDriverId()%>')">Delete</a></td>
	</tr>
<%
	}
%>
</table>

<%
	}
%>
</form>
<s:if test="hasActionMessages()"> 
	<div class="displayMessage">
   		<s:actionmessage/>
	</div>
</s:if>
</center>
<s:include value="footer.jsp" />
</body>
</html>