package com.Bluewind.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bluewind.dto.admin.ProductTypeDTO;
import com.Bluewind.service.IProductTypeService;

@RestController(value = "productTypeAPIOfAdmin")
public class ProductTypeAPI {
	
	@Autowired
	private IProductTypeService producTypeService;
	
	@PostMapping("/api/producttype")
	public ProductTypeDTO createProductType(@RequestBody ProductTypeDTO productTypeDTO) {
		return producTypeService.insert(productTypeDTO);
	}
	@PutMapping("/api/producttype")
	public ProductTypeDTO updateProductType(@RequestBody ProductTypeDTO productTypeDTO) {
		return producTypeService.update(productTypeDTO);
	}
	@DeleteMapping("/api/producttype")
	public void deleteProductType(@RequestBody Integer idProductType) {
		producTypeService.delete(idProductType);
	}
}
