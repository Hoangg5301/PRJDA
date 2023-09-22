package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class RateDTO extends AbstractDTO<RateDTO>{
	private int idTK;
	private int idProduct;
	private int rate;
	public int getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
