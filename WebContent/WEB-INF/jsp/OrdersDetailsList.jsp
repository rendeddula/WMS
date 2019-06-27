<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Order Details</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>List Order Details</h2>

	
<table  style="border: 2px solid red;">


<tr>
<td><b>Item</b></td>
<td><b>Quantity</b> </td>
<td><b>Packed Quantity</b> </td>
<td><b>Status</b> </td>

<td><b>View</b></td>
<td><b>Edit</b></td>
<td><b>Delete</b></td>

<td><a href="">Add</a></td>
</tr>




			<c:forEach var="listValue" items="${orderdetails}">
			<tr>
			<td> ${listValue.item}   </td>
			<td> ${listValue.quantity}   </td>
			<td> ${listValue.packedquantity}   </td>
			<td> ${listValue.status}   </td>
			
			
			<td><a href="">View</a></td>
			
			<td><a href="">Edit</a></td>
			
			<td><a href="">Delete</a></td>
			
			</tr>
			
				
			</c:forEach>

</table>		
</body>
</html>