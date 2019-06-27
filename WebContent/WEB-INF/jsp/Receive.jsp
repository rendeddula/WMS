<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Orders</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>List Receiving</h2>

<b style="color:  red;">
${error}
</b>
<form action="RecieveListInventory" method="post">
	
<table  style="border: 2px solid red;">
	<tr>
		<td style="padding-right: 10px; padding-bottom: 20px;">PO</td>
		<td>
			<select name="poid">
			<c:forEach items="${polist }" var="po">
				<option value="${po.orderHeaderId}">${po.ordername} </option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			Item :
		</td>
		<td>
			<select name=item >
 		 
 		 <c:forEach  items="${itemlist}" var="item">
				<option value="${item.itemId}" >${item.name}</option>
		
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>Qty</td>
		<td><input type="text" name="qty" value=""> </td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Receive">
		</td>
	</tr>

</table>	

</form>	
</body>
</html>