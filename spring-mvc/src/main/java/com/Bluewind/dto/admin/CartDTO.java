package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class CartDTO extends AbstractDTO<CartDTO>{
	private int cartID;
	private int accountID;
	private int productID;
	private int quantity;

	
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
