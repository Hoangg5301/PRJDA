package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class ProductTypeDTO extends AbstractDTO<ProductTypeDTO>{
	private Integer typeID;
	private String typeName;
	
	private String typeDetail;

	
	public String getTypeDetail() {
		return typeDetail;
	}

	public void setTypeDetail(String typeDetail) {
		this.typeDetail = typeDetail;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	
}
