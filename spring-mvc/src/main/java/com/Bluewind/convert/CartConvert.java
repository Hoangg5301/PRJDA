package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.entity.CartEntity;


@Component
public class CartConvert {
	public CartDTO toDTO(CartEntity cartEntity) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartID(cartEntity.getCartID());
		cartDTO.setAccountID(cartEntity.getAccountID());
		cartDTO.setProductID(cartEntity.getProductID());
		cartDTO.setQuantity(cartEntity.getQuantity());
		return cartDTO;
	}
	
	public CartEntity  toEntity(CartDTO cartDTO) {
		CartEntity cartEntity  = new CartEntity();

		cartEntity.setAccountID(cartDTO.getAccountID());
		cartEntity.setProductID(cartDTO.getProductID());
		cartEntity.setQuantity(cartDTO.getQuantity());
		return cartEntity;
	}
	
	public CartEntity toEntity(CartDTO cartDTO, CartEntity oldEntity) {
		oldEntity.setAccountID(cartDTO.getAccountID());
		oldEntity.setProductID(cartDTO.getProductID());
		oldEntity.setQuantity(cartDTO.getQuantity()	);
		return oldEntity;
	}
}
