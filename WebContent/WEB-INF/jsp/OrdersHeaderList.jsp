<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Orders</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>List Orders</h2>

	
<table  style="border: 2px solid red;">


<tr>
<td><b>Order Name</b></td>
<td><b>Order Type</b> </td>
<td><b>Shipping Address</b> </td>
<td><b>DestName</b> </td>
<td><b>DestAddress</b></td>
<td><b>DestCity</b></td>
<td><b>DestState</b></td>
<td><b>DestCountry</b></td>
<td><b>PinCode</b></td>
<td><b>Status</b></td>
<td><b>View</b></td>
<td><b>Edit</b></td>
<td><b>Delete</b></td>

<td><a href="newOrders">Add</a></td>
</tr>




			<c:forEach var="listValue" items="${ordersheader}">
			<tr>
			<td> ${listValue.ordername}   </td>
			<td> ${listValue.ordertype}   </td>
			<td> ${listValue.shippingaddress}   </td>
			<td> ${listValue.destname}   </td>
			<td> ${listValue.destaddress}   </td>
			<td> ${listValue.destcity}   </td>
			<td> ${listValue.deststate}   </td>
			<td> ${listValue.destcountry}   </td>
			<td> ${listValue.pincode}   </td>
			<td> ${listValue.status}   </td>
			
			<td><a href="<c:url value='/viewOrder?id=${listValue.orderHeaderId}' />">View</a></td>
			
			<td><a href="<c:url value='/editOrder?id=${listValue.orderHeaderId}' />">Edit</a></td>
			
			<td><a href="<c:url value='/deleteOrder?id=${listValue.orderHeaderId}' />">Delete</a></td>
			
			</tr>
			
				
			</c:forEach>

</table>		
</body>
</html>