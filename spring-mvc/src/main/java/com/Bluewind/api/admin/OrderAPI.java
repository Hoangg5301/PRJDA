package com.Bluewind.api.admin;

import com.Bluewind.dto.OdDTO;
import com.Bluewind.dto.admin.BrandDTO;
import com.Bluewind.service.OdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "orderAPIOfAdmin")
public class OrderAPI {

    @Autowired
    private OdService odService;

    @PutMapping("/api/order")
    public OdDTO updateBrand(@RequestBody OdDTO odDTO) {
        return odService.updatebyOdID(odDTO);
    }
}
