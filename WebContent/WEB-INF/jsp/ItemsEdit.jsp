<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Items Edit </title>
</head>
<body>
<%@include file="common/header.jsp" %>

<h3>Edit Item</h3>

<div>
	<form action="updateItem" method="post">
	
		<input type="hidden" name="itemId" value="${listValue.itemId }"/> 
		<br><br>

		
		Item Name :<input type="text" name="name" value="${listValue.name}">
		<br><br>
		Description:<input type="text" name="description" value="${listValue.description}">
		<br><br>
		Bar Code :<input type="text" name="barcode" value="${listValue.barcode}">
		<br><br>
		Price:<input type="text" name="price" value="${listValue.price}">
		<br><br>
		Weight:<input type="text" name="weight" value="${listValue.weight}">
		<br><br>
		<button>Update</button>
		</form>
	</div>
</body>
</html>