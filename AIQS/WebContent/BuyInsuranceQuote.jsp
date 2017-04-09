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
<script type="text/javascript">
function fn(e){
	var p=document.fr.policyType.value;
	if(p=="Renewal"){
		document.fr.prevPolicyExpDate.disabled=false;
		return true;
	}
}
</script>
</head>
<body>
<s:include value="header.jsp" />
	<s:form action="buy_quote" method="post" name="fr">
	<s:select list="{'New','Renewal'}" name="biq.policyType" label="Policy Type" onchange="return fn(event);"></s:select>
	<sx:datetimepicker label="Policy Start Date" name ="biq.policyStartDate"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<sx:datetimepicker label="Previous Policy Expiry Date" name ="biq.prevPolicyExpDate"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true" disabled="true"/>
	<s:select list="{'Tata','Toyoto'}" name="biq.vehicleMake" label="Vehicle Make"></s:select>
	<s:select list="{'Innovo','Aristo'}" name="biq.vehicleModel" label="Vehicle Model"></s:select>
	<s:textfield label ="Year Of Manufacture" name ="biq.yearOfManuf" />
	<sx:datetimepicker label="Date Of Registration" name ="biq.regDate"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<s:textfield label ="State Of Registration" name ="biq.regState" />
	<s:textfield label ="City Of Registration" name ="biq.regCity" />
	<s:textfield label ="Fuel Type" name ="biq.fuelType" />
	<s:textfield label ="Showroom Price" name ="biq.showroomPrice" />
	<sx:datetimepicker label="DOB Of Owner" name ="biq.dobOwner"  adjustWeeks="true" displayFormat="dd-MM-yyyy" required="true"/>
	<s:textfield label ="Profession Of Owner" name ="biq.profession" />
	
	<s:submit name="submit" value="BuyInsuranceQuote"/>
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