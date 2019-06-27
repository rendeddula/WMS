<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders Header View</title>
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
 
 <h2>View Orders Header</h2>
 
 <div>
	<form action=viewOrder method="post">
		<div class="tab">
		  <button class="tablinks" onclick="openTab(event, 'Header'); return false;">Order Header</button>
		  <button class="tablinks" onclick="openTab(event, 'Details'); return false;">Details</button>
		</div>
		
<div>
	
	<div id="Header" class="tabcontent">
		<input type="hidden" name="orderHeaderId" value="${listValue.orderHeaderId }"/> 
		
		<b>Order Name:</b>	  ${listValue.ordername} <br><br>
		<b>Order Type:</b> ${listValue.ordertype}  <br><br>
		<b>shipping address:</b> ${listValue.shippingaddress}   	<br><br>
		<b>DestName:</b> ${listValue.destname}   	<br><br>
		<b>DestAddress :</b>  ${listValue.destaddress}  	<br><br>
		<b>DestCity :</b>  ${listValue.destcity}   	<br><br>
		<b>DestState :</b>  ${listValue.deststate}   	<br><br>
		<b>DestCountry:</b>  ${listValue.destcountry}  	<br><br>
		<b>PinCode :</b>  ${listValue.pincode}   	<br><br>
		<b>Status:</b>  ${listValue.status}   	<br><br>

	</div>
	</div>	
	
	<div id="Details" class="tabcontent">
 		
 		<c:forEach items="${orderdetails}" var="details">
 		
 		<b>Item:</b>	
 		   ${details.item}
 		 
 		  <br><br>
		
		<b>Quantity:</b> ${details.quantity}  <br><br>
		<b>Packed Quantity:</b> ${details.packedquantity}   	<br><br>
		<b>Status:</b> ${details.status}   	<br><br>
	</c:forEach>
		
</div>	
		</form>
	</div>
</body>
</html>