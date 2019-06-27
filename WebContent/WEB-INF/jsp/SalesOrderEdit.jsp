<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edit Sales Order </title>
</head>
<body>
<%@include file="common/header.jsp" %>

<h3>Edit Sales Order </h3>

<div>
	<form action="updateSalesOrder" method="post">
	
		<input type="hidden" name="orderHeaderId" value="${listValue.orderHeaderId }"/> 
		<br><br>

		
		Order Name :<input type="text" name="ordername" value="${listValue.ordername }">
		<br><br>
		
		Shipping Address :<input type="text" name="shippingaddress" value="${listValue.shippingaddress }">
		<br><br>
		DestName:<input type="text" name="destname" value="${listValue.destname }">
		<br><br>
		DestAddress:<input type="text" name="destaddress" value="${listValue.destaddress }">
		<br><br>
		DestCity:<input type="text" name="destcity" value="${listValue.destcity }">
		<br><br>
		DestState:<input type="text" name="deststate" value="${listValue.deststate }">
		<br><br>
		DestCountry:<input type="text" name="destcountry" value="${listValue.destcountry }">
		<br><br>
		PinCode:<input type="text" name="pincode" value="${listValue.pincode }">
		<br><br>
		Status:
		<select name="status">
		<option value="wip">WIP</option>
		<option value="open">CREATED</option>
		<option value="closed">CLOSED</option>
		</select>
		
		<br><br>
		<button>Update</button>
		</form>
	</div>
</body>
</html>