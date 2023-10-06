package com.Bluewind.api.user;

import com.Bluewind.convert.ProductTypeConvert;
import com.Bluewind.dto.admin.ProductTypeDTO;
import com.Bluewind.service.impl.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "productTypeAPIOfUser")
public class ProductTypeAPI {
    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    ProductTypeConvert productTypeConvert;

    @GetMapping("/getproducttype")
    public List<ProductTypeDTO> getProductType(){
        List<ProductTypeDTO> listProductTypeDTO = productTypeService.findAll();
        return listProductTypeDTO;
    }
}
