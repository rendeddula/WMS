<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Items</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>List Items</h2>

	
<table  style="border: 2px solid red;">


<tr>
<td><b>Item Name</b></td>
<td><b>Description</b> </td>
<td><b>Bar Code</b> </td>
<td><b>Price</b> </td>
<td><b>Weight</b></td>

<td><b>View</b></td>
<td><b>Edit</b></td>
<td><b>Delete</b></td>
<td><a href="newItems">Add</a></td>
</tr>




			<c:forEach var="listValue" items="${items}">
			<tr>
			<td> ${listValue.name}   </td>
			<td> ${listValue.description } </td>
			<td> ${listValue.barcode} </td>
			<td> ${listValue.price } </td>
			<td> ${listValue.weight } </td>
			
			<td><a href="<c:url value='/viewItem?id=${listValue.itemId}' />">View</a></td>
			
			<td><a href="<c:url value='/editItem?id=${listValue.itemId}' />">Edit</a></td>
			
		    <td><a href="<c:url value='/deleteItem?id=${listValue.itemId}' />">Delete</a></td>
			</tr>
			
				
			</c:forEach>

</table>		
</body>
</html>