<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Orders Insert</title>

<script>
function openTab(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>

<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>

</head>
<body>
<%@include file="common/header.jsp" %>
 
 <h2>Add Order</h2>
<div>
	<form action="addSalesOrders" method="post">
		<div class="tab">
		  <button class="tablinks" onclick="openTab(event, 'Header'); return false;">Order Header</button>
		  <button class="tablinks" onclick="openTab(event, 'Details'); return false;">Details</button>
		</div>	
		
		
		<div id="Header" class="tabcontent">
  <br><br>
		
	
		Order Name :<input type="text" name="ordername" value="">
		<br><br>
		
		Shipping Address :<input type="text" name="shippingaddress" value="">
		<br><br>
		DestName:<input type="text" name="destname" value="">
		<br><br>
		DestAddress:<input type="text" name="destaddress" value="">
		<br><br>
		DestCity:<input type="text" name="destcity" value="">
		<br><br>
		DestState:<input type="text" name="deststate" value="">
		<br><br>
		DestCountry:<input type="text" name="destcountry" value="">
		<br><br>
		PinCode:<input type="text" name="pincode" value="">
		<br><br>
		Status:
		<select name="status">
		
		<option value="open">CREATED</option>
		<option value="closed">CLOSED</option>
		</select>
		
		<br><br>
		
		<button>Save</button>
</div>

<div id="Details" class="tabcontent">
 		
 		Item :
 		
 		 <select name=item >
 		 
 		 <c:forEach  items="${itemlist}" var="item">
				<option value="${item.itemId}" >${item.name}</option>
		
		</c:forEach>
		</select>
 	
		<br><br>
		Quantity:<input type="text" name="quantity" value="">
		<br><br>
		Packed Quantity :<input type="text" name="packedquantity" value="">
		<br><br>
		Status:<input type="text" name="status" value="">
		<br><br>
		<button>Save</button>
</div>
		
			 
		
	</form>
	</div>
</body>
</html>