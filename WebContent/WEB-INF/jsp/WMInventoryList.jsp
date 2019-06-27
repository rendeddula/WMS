<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Orders</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>List WM Inventory</h2>

	
<table  style="border: 2px solid red;">


<tr>
<td><b>Item</b></td>
<td><b>Available Qty</b> </td>

</tr>




			<c:forEach var="listValue" items="${wminventory}">
			<tr>
			<td> ${listValue.itemName} </td>
			<td> ${listValue.allocatedQty}   </td>
		
		
			</tr>
			
				
			</c:forEach>

</table>		
</body>
</html>