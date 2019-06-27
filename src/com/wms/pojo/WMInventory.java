package com.wms.pojo;

public class WMInventory {

	
	private Integer inventoryId;
	private Integer itemId;
	private Integer locationId;
	private String availableqty;
	private String allocatedqty;

	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public String getAvailableqty() {
		return availableqty;
	}
	public void setAvailableqty(String availableqty) {
		this.availableqty = availableqty;
	}
	public String getAllocatedqty() {
		return allocatedqty;
	}
	public void setAllocatedqty(String allocatedqty) {
		this.allocatedqty = allocatedqty;
	}
	
}
