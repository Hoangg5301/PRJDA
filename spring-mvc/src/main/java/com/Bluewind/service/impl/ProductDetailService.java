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
		ProductDetailEntity test = productDetailRepository.findByProduct(dto.getProductID(), dto.getSize());
		if(test == null){
			return productDetailConvert.toDTO(productDetailRepository.save(productDetailEntity));
		}else{
			Integer quantityNew = test.getQuantity() + dto.getQuantity();
			productDetailEntity.setQuantity(quantityNew);
			return productDetailConvert.toDTO(productDetailRepository.save(productDetailEntity));
		}
	}

	@Override
	public void delete(ProductDetailDTO dto) {
		ProductDetailEntity productDetailEntity = productDetailConvert.toEntity(dto);
		productDetailRepository.delete(productDetailEntity);
	}

	@Override
	public void update(ProductDetailDTO dto) {
		ProductDetailDTO productDetailDTO = productDetailConvert.toDTO(productDetailRepository.findOne(dto.getProductDetailID()));
		Integer quantity = productDetailDTO.getQuantity() + dto.getQuantity();

		productDetailRepository.updateProductDetail(quantity, dto.getSize(), dto.getProductDetailID());
	}

    @Override
    public List<ProductDetailDTO> findAllByProductIds(List<Integer> ids) {
        List<ProductDetailDTO> productDetailDTOS = new ArrayList<>();

        if (!ids.isEmpty()) {
            List<ProductDetailEntity> productDetailEntities = productDetailRepository.findAllByProductIds(ids);
            if (!productDetailEntities.isEmpty()) {
                for (ProductDetailEntity detail : productDetailEntities) {
                    productDetailDTOS.add(productDetailConvert.toDTO(detail));

                }
            }
        }
        return productDetailDTOS;
    }

	@Override
	public List<ProductDetailDTO> findListProductDetailByProduct(Integer id) {
		List<ProductDetailEntity> listProductDetail = productDetailRepository.findListProductDetailByProduct(id);
		List<ProductDetailDTO> listProductDetailDTO = new ArrayList<>();

		for(ProductDetailEntity productDetailEntity : listProductDetail){
			ProductDetailDTO productDetailDTO = productDetailConvert.toDTO(productDetailEntity);
			listProductDetailDTO.add(productDetailDTO);
		}
		return listProductDetailDTO;
	}

	@Override
	public ProductDetailDTO findoneID(Integer id) {
		ProductDetailDTO productDetailDTO = productDetailConvert.toDTO(productDetailRepository.findOne(id));

		return productDetailDTO;
	}


}
