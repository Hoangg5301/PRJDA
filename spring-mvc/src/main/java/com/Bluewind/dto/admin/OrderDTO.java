package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

import java.util.Date;

public class OrderDTO extends AbstractDTO<OrderDTO>{

	private Integer orderID;

	private String fullName;
	private Date createTime;
	private String status;
	private String address;
	private String phoneNumber;
	private Integer promotionID;
	private Integer accountID;

	public Integer getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(Integer promotionID) {
		this.promotionID = promotionID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
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

	
}
