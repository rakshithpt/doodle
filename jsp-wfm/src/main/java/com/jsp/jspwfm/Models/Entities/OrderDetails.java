package com.jsp.jspwfm.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class OrderDetails {
	
	@Id
	private int prodId;
	private int noOforders;
	private int userId;
	
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getNoOforders() {
		return noOforders;
	}
	public void setNoOforders(int noOforders) {
		this.noOforders = noOforders;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public OrderDetails(int prodId, int noOforders, int userId) {
		super();
		this.prodId = prodId;
		this.noOforders = noOforders;
		this.userId = userId;
	}
	public OrderDetails() {
		super();
	}
	

}
