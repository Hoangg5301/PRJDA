package com.Bluewind.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	@PostMapping("/api/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.insert(productDTO);
	}
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.update(productDTO);
	}
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody Integer id) {
		productService.delete(id);
	}
}
