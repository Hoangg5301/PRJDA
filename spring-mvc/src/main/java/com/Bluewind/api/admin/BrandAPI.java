package com.Bluewind.api.admin;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.service.IBrandService;

@RestController(value = "brandAPIOfAdmin")
public class BrandAPI {
	
	@Autowired
	private IBrandService brandService;
	
	//upload file
	@Autowired
	ServletContext context;
	
	@PostMapping("/api/brand")
	public BrandDTO createBrand(@RequestBody BrandDTO brandDTO) {
		return brandService.insert(brandDTO);
	}
	@PutMapping("/api/brand")
	public BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) {
		return brandService.update(brandDTO);
	}
	@DeleteMapping("/api/brand")
	public void deleteBrand(@RequestBody Integer idBrand) {
		brandService.delete(idBrand);
	}
	
	
	@PostMapping("/api/upload/brand")
	public String uploadFile(@RequestParam MultipartFile img1, @RequestParam Integer id) {
		
		String fileName1 = img1.getOriginalFilename(); 
		try {
			FileCopyUtils.copy(img1.getBytes(), new File("C:\\Users\\Admin\\dev\\t\\PRJDA\\spring-mvc\\src\\main\\webapp\\image\\" + fileName1));
			String part = ("/image/"+fileName1);
			if(id == null) {
				brandService.uploadAdd(part);
			}else {
				brandService.uploadUpdate(id, part);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
