package com.Bluewind.entity;

import javax.persistence.*;

@Entity
@Table(name="brand")
public class BrandEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbrand")
	private Integer brandID;
	@Column(name = "brandname")
	private String brandName;
	@Column(name = "brandImg")
	private String brandImg;
	public String getBrandImg() {
		return brandImg;
	}
	public void setBrandImg(String brandImg) {
		this.brandImg = brandImg;
	}

	public Integer getBrandID() {
		return brandID;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
