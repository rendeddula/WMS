package com.wms.pojo;

public class OrdersDetails {

	
	private Integer detailsId;
	private String item;
	private String quantity;
	private String packedquantity;
	private String status;
	private OrdersHeader orderHeader;
	private Integer headerId;
	
	
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPackedquantity() {
		return packedquantity;
	}
	public void setPackedquantity(String packedquantity) {
		this.packedquantity = packedquantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrdersHeader getOrderHeader() {
		return orderHeader;
	}
	public void setOrderHeader(OrdersHeader orderHeader) {
		this.orderHeader = orderHeader;
	}
	public Integer getHeaderId() {
		return headerId;
	}
	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}
	
	
	@Override
	public String toString() {
		System.out.println("Item : "+this.item);
		return this.item;
	}
}
