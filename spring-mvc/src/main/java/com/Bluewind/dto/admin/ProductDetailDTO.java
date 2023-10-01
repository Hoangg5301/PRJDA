package com.Bluewind.dto.admin;

public class ProductDetailDTO {
	private Integer productDetailID;
	private Integer productID;
	private String size;
	private Integer quantity;
	public Integer getProductDetailID() {
		return productDetailID;
	}
	public void setProductDetailID(Integer productDetailID) {
		this.productDetailID = productDetailID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
