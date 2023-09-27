package com.Bluewind.api.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bluewind.dto.admin.CartDTO;
import com.Bluewind.service.ICartService;

@RestController(value = "cartdAPIOfUser")
public class CartAPI {
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/api/user/cart")
	public CartDTO createCart(@RequestBody CartDTO cartDTO) {
		return cartService.insert(cartDTO);
	}
	@PutMapping("/api/user/cart")
	public CartDTO updateCart(@RequestBody CartDTO cartDTO) {
		return cartService.update(cartDTO);
	}
	@DeleteMapping("/api/user/cart")
	public void deleteCart(@RequestBody Integer accountID) {
		cartService.delete(accountID);
	}
}
