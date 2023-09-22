package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class BrandDTO extends AbstractDTO<BrandDTO>{

	private String brandName;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
