package com.Bluewind.api.admin;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.service.IProductDetailService;
import com.Bluewind.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	@PostMapping("/api/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO productDTOOut =  productService.insert(productDTO);
//		Integer idLast = productService.findlastID();
//		ProductDetailDTO productDetailDTO = new ProductDetailDTO();
//		productDetailDTO.setProductID(idLast);
//		productDetailDTO.setQuantity(productDTO.getQuantity());
//		productDetailDTO.setSize(productDTO.getSize());
//		productDetailService.insert(productDetailDTO);
		return productDTOOut;
	}
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.update(productDTO);
	}
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody Integer id) {
		productService.delete(id);
	}
	
	@PostMapping("/api/upload/product")
	public String uploadFile(@RequestParam MultipartFile[] img, @RequestParam Integer id) {
		
		String fileName1 = img[0].getOriginalFilename();
		String fileName2 = img[1].getOriginalFilename();
		String fileName3 = img[2].getOriginalFilename();
		String fileName4 = img[3].getOriginalFilename();
		try {
			FileCopyUtils.copy(img[0].getBytes(), new File("F:/DATN/BlueWindShop/spring-mvc/src/main/webapp/image/" + fileName1));
			FileCopyUtils.copy(img[1].getBytes(), new File("F:/DATN/BlueWindShop/spring-mvc/src/main/webapp/image/" + fileName2));
			FileCopyUtils.copy(img[2].getBytes(), new File("F:/DATN/BlueWindShop/spring-mvc/src/main/webapp/image/" + fileName3));
			FileCopyUtils.copy(img[3].getBytes(), new File("F:/DATN/BlueWindShop/spring-mvc/src/main/webapp/image/" + fileName4));
			
			String path1 = ("/image/"+fileName1);
			String path2 = ("/image/"+fileName2);
			String path3 = ("/image/"+fileName3);
			String path4 = ("/image/"+fileName4);
			if(id == null) {
				productService.uploadAdd(path1, path2, path3, path4);
			}else {
				productService.uploadUpdate(path1, path2, path3, path4, id);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
