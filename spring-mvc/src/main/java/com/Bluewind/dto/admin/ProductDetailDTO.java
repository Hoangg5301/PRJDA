package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class ProductDetailDTO extends AbstractDTO<ProductDetailDTO> {
	private Integer productDetailID;
	private String productName;
	private Integer productID;
	private String size;
	private Integer quantity;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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
