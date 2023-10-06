package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;
import lombok.Getter;

import java.util.Date;

@Getter
public class OrderDTO extends AbstractDTO<OrderDTO>{

	private Integer orderID;

	private String fullName;
	private Date createTime;
	private String status;
	private String address;
	private String phoneNumber;
	private Integer discount;
	private Integer accountID;

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
