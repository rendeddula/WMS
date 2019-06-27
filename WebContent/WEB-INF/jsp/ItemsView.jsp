<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items View</title>
</head>
<body>
<%@include file="common/header.jsp" %>
 
 <h2>View Item</h2>
<div>
	<form action=viewItem method="post">
	
		<input type="hidden" name="itemId" value="${listValue.itemId }"/> 
		
		
		<c:forEach var="listValue" items="${items}">
			<tr>
	<tr>	<td><b>Item Name</b></td> </tr> 	<td> ${listValue.name}   </td> 
		<br><br>
		
	<tr>	<td><b>Description</b> </td>	</tr>       <td> ${listValue.description } </td>
		<br><br>
		<td><b>Bar Code</b> </td>	<td> ${listValue.barcode} </td>
			<br><br>
		<td><b>Price</b> </td>	<td> ${listValue.price } </td>
			<br><br>
	<tr>	<td><b>Weight</b></td> </tr>	<td> ${listValue.weight } </td>
			</tr>
	
	</c:forEach>
		
		</form>
	</div>
</body>
</html>