package com.Bluewind.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDProduct")
	private Integer productID;

	@Column(name = "productName")
	private String productName;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "meterial")
	private String meterial;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "describe_detail")
	private String describeDetail;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "img1")
	private String img1;
	
	@Column(name = "img2")
	private String img2;
	
	@Column(name = "img3")
	private String img3;
	
	@Column(name = "img4")
	private String img4;
	
	@Column(name = "IDType")
	private Integer typeID;
	
	@Column(name = "IDBrand")
	private Integer brandID;
}
