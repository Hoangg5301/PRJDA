package com.Bluewind.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {
	private int cartID;
	private int accountID;
	private int productID;
	private int quantity;
}
