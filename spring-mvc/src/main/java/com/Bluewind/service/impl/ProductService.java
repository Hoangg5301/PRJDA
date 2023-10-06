package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bluewind.convert.ProductConvert;
import com.Bluewind.dto.admin.ProductDTO;
import com.Bluewind.entity.BrandEntity;
import com.Bluewind.entity.ProductDetailEntity;
import com.Bluewind.entity.ProductEntity;
import com.Bluewind.repository.BrandRepository;
import com.Bluewind.repository.ProductDetailRepository;
import com.Bluewind.repository.ProductRepository;
import com.Bluewind.service.IProductService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductConvert productConvert;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductDetailRepository ProductDetailRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public ProductDTO update(ProductDTO dto) {
        ProductEntity oldEntity = productRepository.findOne(dto.getProductID());
        oldEntity = productConvert.toEntity(dto, oldEntity);
        oldEntity = productRepository.save(oldEntity);
        ProductDTO productDTO = productConvert.toDTO(oldEntity);
        //update Detail
        Integer productId = dto.getProductID();
        ProductDetailEntity ProductDetailEntity = ProductDetailRepository.findByProduct(productId, dto.getSize());
        ProductDetailEntity.setQuantity(ProductDetailEntity.getQuantity() + dto.getQuantity());
        ProductDetailRepository.save(ProductDetailEntity);

        return productDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> listProductDTO = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();

        for (ProductEntity productEntity : productEntityList) {
            productEntity.setQuantity(ProductDetailRepository.sumQuatity(productEntity.getProductID()));
            listProductDTO.add(productConvert.toDTO(productEntity));
        }
        return listProductDTO;
    }

    @Override
    public ProductDTO findById(Integer id) {
        return productConvert.toDTO(productRepository.findOne(id));
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        ProductEntity productEntity = productConvert.toEntity(dto);
        ProductDTO productDTO = productConvert.toDTO(productRepository.save(productEntity));

        return productDTO;
    }

//    @Override
//    @Transactional
//    public ProductDTO update(ProductDTO dto) {
//        ProductEntity oldEntity = productRepository.findOne(dto.getProductID());
//        oldEntity = productConvert.toEntity(dto, oldEntity);
//        oldEntity = productRepository.save(oldEntity);
//        ProductDTO productDTO = productConvert.toDTO(oldEntity);
//        //update Detail
//        Integer productId = dto.getProductID();
//        ProductDetailEntity ProductDetailEntity = ProductDetailRepository.findByProduct(productId, dto.getSize());
//        if (ProductDetailEntity == null) {
//            ProductDetailEntity = new ProductDetailEntity();
//            ProductDetailEntity.setProductID(productId);
//            ProductDetailEntity.setQuantity(dto.getQuantity());
//            ProductDetailEntity.setSize(dto.getSize());
//            ProductDetailRepository.save(ProductDetailEntity);
//        } else {
//            ProductDetailEntity.setQuantity(ProductDetailEntity.getQuantity() + dto.getQuantity());
//            ProductDetailRepository.save(ProductDetailEntity);
//        }
//        return productDTO;
//    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ProductDetailRepository.deleteProduct(id);
        productRepository.delete(id);
    }

    @Override
    @Transactional
    public void uploadAdd(String path1, String path2, String path3, String path4) {
        Integer id = productRepository.findLastId();
        productRepository.uploadAdd(path1, path2, path3, path4, id);

    }

    @Override
    @Transactional
    public void uploadUpdate(String path1, String path2, String path3, String path4, Integer id) {
        productRepository.uploadUpdate(path1, path2, path3, path4, id);

    }

    @Override
    public List<ProductDTO> findLast() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductEntity> productEntity = productRepository.findTop4ByOrderByProductIDDesc();
        for (ProductEntity p : productEntity) {
            productDTOS.add(productConvert.toDTO(p));
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findAllByBrandID(Integer brandID) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findTop4ByBrandID(brandID);
        if (!productEntityList.isEmpty()) {
            for (ProductEntity productEntity : productEntityList) {
                productDTOS.add(productConvert.toDTO(productEntity));
            }
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findAllByProductIds(List<Integer> ids) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        if (ids.isEmpty()) {
            return new ArrayList<>();
        }
        List<ProductEntity> productEntityList = productRepository.findAllByProductIds(ids);
        if (!productEntityList.isEmpty()) {
            for (ProductEntity entity : productEntityList) {
                productDTOS.add(productConvert.toDTO(entity));
            }
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findByProductNameLike(String productName) {
        List<ProductDTO> productDTOS;
        List<ProductEntity> productEntities;
        if (productName.isEmpty()) {
            productEntities = productRepository.findAll();
        } else {
            productEntities = productRepository.findByProductNameIsContaining(productName);
        }
        productDTOS = productEntities.stream().map(p -> productConvert.toDTO(p)).collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findByBrandIDAndTypeIDAndPriceBetween(Integer brandID, Integer typeID, Integer price, Integer price2, boolean asc) {
        List<ProductDTO> productDTOS;
        List<ProductEntity> productEntities;

        String sql = "select p from ProductEntity p where";

        if (brandID != 0) {
            sql += " p.brandID = :brandID and";
        }
        if (typeID != 0) {
            sql += " p.typeID = :typeID and";
        }
        if (price < price2) {
            sql += " p.price between :price and :price2";
        }

        if (sql.endsWith("where")) {
            sql = sql.substring(0, Math.max(0, sql.length() - "where".length()));
        }
        if (sql.endsWith("and")) {
            sql = sql.substring(0, Math.max(0, sql.length() - "and".length()));
        }

        sql += "  order by price";
        if (!asc) {
            sql += " desc";
        }

        TypedQuery<ProductEntity> query = entityManager.createQuery(sql, ProductEntity.class);

        if (brandID != 0) {
            query.setParameter("brandID", brandID);
        }
        if (typeID != 0) {
            query.setParameter("typeID", typeID);
        }
        if (price < price2) {
            query.setParameter("price", price);
            query.setParameter("price2", price2);
        }

        productEntities = query.getResultList();


//        if (brandID != 0) {
//            productEntities = productRepository.findAll();
//        } else {
//            if (asc) {
//                productEntities = productRepository.findByBrandIDAndTypeIDAndPriceBetweenOrderByPriceAsc(brandID, typeID, price, price2);
//            } else {
//                productEntities = productRepository.findByBrandIDAndTypeIDAndPriceBetweenOrderByPriceDesc(brandID, typeID, price, price2);
//            }
//        }
        productDTOS = productEntities.stream().map(p -> productConvert.toDTO(p)).collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findBrandName(ProductDTO listProductInDTO) {
        List<ProductDTO> listProductOutDTO = new ArrayList<>();
        for (ProductDTO productDTO : listProductInDTO.getListResult()) {
            Integer id = productDTO.getBrandID();
            BrandEntity brandEntity = brandRepository.findOne(id);
            if (brandEntity != null) {
                productDTO.setBrandName(brandEntity.getBrandName());
                listProductOutDTO.add(productDTO);
            }
        }
        return listProductOutDTO;
    }

    @Override
    public Integer findlastID() {

        return productRepository.findLastId();
    }

}
