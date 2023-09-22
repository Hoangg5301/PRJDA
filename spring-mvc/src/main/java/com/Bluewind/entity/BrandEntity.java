package com.Bluewind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class BrandEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDBrand;
	@Column(name = "brandname")
	private String brandName;
	public int getIDBrand() {
		return IDBrand;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
