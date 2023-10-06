package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;
import lombok.Getter;

@Getter
public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{

	private Integer orderDetailID;
	private Integer productID;
	private Integer orderID;

	private Integer quantity;

	public void setOrderDetailID(Integer orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
