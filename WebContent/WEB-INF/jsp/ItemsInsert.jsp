<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items Insert</title>
</head>
<body>
<%@include file="common/header.jsp" %>
 
 <h2>Add Item</h2>
<div>
	<form action="additem" method="post">
		<br><br>
		
	
		Item Name :<input type="text" name="name" value="">
		<br><br>
		Description:<input type="text" name="description" value="">
		<br><br>
		Bar Code :<input type="text" name="barcode" value="">
		<br><br>
		Price:<input type="text" name="price" value="">
		<br><br>
		Weight:<input type="text" name="weight" value="">
		<br><br>
		
		<button>Save</button>
		</form>
	</div>
</body>
</html>