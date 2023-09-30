package com.Bluewind.entity;

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
	
	@Column(name = "quantity")
	private int quantity;

	@OneToMany(mappedBy = "cartEntity")
	private List<BrandEntity> brandEntities;

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
