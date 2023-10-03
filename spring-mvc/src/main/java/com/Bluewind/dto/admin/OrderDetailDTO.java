package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{

	private Integer orderDetailID;
	private Integer productID;
	private Integer orderID;

	private Integer quantity;

	public Integer getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(Integer orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
