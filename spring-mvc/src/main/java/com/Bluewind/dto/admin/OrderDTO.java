package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class OrderDTO extends AbstractDTO<OrderDTO>{
	private String createTime;
	private String status;
	private String address;
	private String phoneNumber;
	private int idTK;
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}

	
	
}
