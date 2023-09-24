package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class BrandDTO extends AbstractDTO<BrandDTO>{
	private Integer brandID;
	private String brandName;
	private String brandImg;
	
	public Integer getBrandID() {
		return brandID;
	}
	public void setBrandID(Integer brandID) {
		this.brandID = brandID;
	}
	public String getBrandImg() {
		return brandImg;
	}
	public void setBrandImg(String brandImg) {
		this.brandImg = brandImg;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
