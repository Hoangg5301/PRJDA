package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class cartDTO extends AbstractDTO<cartDTO>{
	private int idTK;
	private int idProduct;
	private int quantity;
	public int getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
