package com.Bluewind.api.admin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Bluewind.dto.admin.BrandDTO;

@RestController(value = "brandAPIOfAdmin")
public class BrandAPI {
	
	@PostMapping("/api/brand")
	public BrandDTO createBrand(@RequestBody BrandDTO brandDTO) {
		return brandDTO;
	}
	@PutMapping("/api/brand")
	public BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) {
		return brandDTO;
	}
	@DeleteMapping("/api/brand")
	public void deleteBrand(@RequestBody int idBrand) {
		
	}
}