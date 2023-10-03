package com.Bluewind.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="cart")
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="IDCart")
	private Integer cartID;
	
	@Column(name ="IDTK")
	private Integer accountID;
	
	@Column(name ="IDProduct")
	private Integer productID;

	public CartEntity(Integer accountID, Integer productID, int quantity) {
		this.accountID = accountID;
		this.productID = productID;
		this.quantity = quantity;
	}

	@Column(name = "quantity")
	private int quantity;

	public CartEntity() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getCartID() {
		return cartID;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
}
