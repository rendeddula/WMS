<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Packing</title>
<body>
<%@include file="common/header.jsp" %>
	<h2>Packing</h2>

<form action="PackingListInventory" method="post">
	
<table  style="border: 2px solid red;">
	<tr>
		<td style="padding-right: 10px; padding-bottom: 20px;">SO</td>
		<td>
			<select name="soid">
			<c:forEach items="${solist}" var="so">
				<option value="${so.orderHeaderId}">${so.ordername} </option>
			</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="submit" value="Pack">
		</td>
	</tr>
</table>	

</form>	
</body>
</html>