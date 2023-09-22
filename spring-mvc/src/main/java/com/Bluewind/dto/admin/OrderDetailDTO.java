package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
	private int idProduct;
	private int idOrder;
	private int quantity;

	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
