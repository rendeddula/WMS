package com.wms.pojo;

import java.util.Set;

public class OrdersHeader {
   private Integer orderHeaderId;
   private String ordername;
   private String ordertype;
   private String shippingaddress;
   private String destname;
   private String destaddress;
   private String destcity;
   private String deststate;
   private String destcountry;
   private String pincode;
   private String status;
   private Set<OrdersDetails> details;
   
   
public Integer getOrderHeaderId() {
	return orderHeaderId;
}
public void setOrderHeaderId(Integer orderHeaderId) {
	this.orderHeaderId = orderHeaderId;
}
public String getOrdername() {
	return ordername;
}
public void setOrdername(String ordername) {
	this.ordername = ordername;
}
public String getOrdertype() {
	return ordertype;
}
public void setOrdertype(String ordertype) {
	this.ordertype = ordertype;
}
public String getShippingaddress() {
	return shippingaddress;
}
public void setShippingaddress(String shippingaddress) {
	this.shippingaddress = shippingaddress;
}
public String getDestname() {
	return destname;
}
public void setDestname(String destname) {
	this.destname = destname;
}
public String getDestaddress() {
	return destaddress;
}
public void setDestaddress(String destaddress) {
	this.destaddress = destaddress;
}
public String getDestcity() {
	return destcity;
}
public void setDestcity(String destcity) {
	this.destcity = destcity;
}
public String getDeststate() {
	return deststate;
}
public void setDeststate(String deststate) {
	this.deststate = deststate;
}
public String getDestcountry() {
	return destcountry;
}
public void setDestcountry(String destcountry) {
	this.destcountry = destcountry;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Set<OrdersDetails> getDetails() {
	return details;
}
public void setDetails(Set<OrdersDetails> details) {
	this.details = details;
}
}
