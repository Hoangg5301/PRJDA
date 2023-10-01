package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.Bluewind.dto.admin.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bluewind.convert.ProductDetailConvert;
import com.Bluewind.dto.admin.ProductDetailDTO;
import com.Bluewind.entity.ProductDetailEntity;
import com.Bluewind.repository.ProductDetailRepository;
import com.Bluewind.service.IProductDetailService;

@Service
public class ProductDetailService implements IProductDetailService{
	
	@Autowired
	private ProductDetailRepository productDetailRepository;
	@Autowired
	private ProductDetailConvert productDetailConvert;
	
	@Override
	public List<ProductDetailDTO> findAll() {
		List<ProductDetailEntity> listProductDetailEntity = productDetailRepository.findAll();
		List<ProductDetailDTO> listProductDetailDTO = new ArrayList<>();
		
		for(ProductDetailEntity productDetailEntity: listProductDetailEntity) {
			ProductDetailDTO productDetailDTO = productDetailConvert.toDTO(productDetailEntity);
			listProductDetailDTO.add(productDetailDTO);
		}
		
		return listProductDetailDTO;
	}

	@Override
	public ProductDetailDTO insert(ProductDetailDTO dto) {
		ProductDetailEntity productDetailEntity = productDetailConvert.toEntity(dto);
		
		return productDetailConvert.toDTO(productDetailRepository.save(productDetailEntity));
	}
	
	public void update(ProductDetailDTO dto) {
		productDetailRepository.updateProductDetail(dto.getQuantity(), dto.getProductID(), dto.getSize());
	}

    @Override
    public List<ProductDetailDTO> findAllByProductIds(List<Integer> ids) {
        List<ProductDetailDTO> productDetailDTOS = new ArrayList<>();

        if (!ids.isEmpty()) {
            List<ProductDetailEntity> productDetailEntities = productDetailRepository.findByProductDetailIDIsIn(ids);
            if (!productDetailEntities.isEmpty()) {
                for (ProductDetailEntity detail : productDetailEntities) {
                    productDetailDTOS.add(productDetailConvert.toDTO(detail));

                }
            }
        }
        return productDetailDTOS;
    }
	
}
