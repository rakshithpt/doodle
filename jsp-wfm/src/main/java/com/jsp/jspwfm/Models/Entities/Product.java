package com.jsp.jspwfm.Models.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int productId;
	private String productName;
	private int productQuantity;
	
	
//	@OneToOne(cascade = CascadeType.ALL , targetEntity = Order.class , fetch = FetchType.LAZY)
//	@JoinColumn(name = "prodID" ,  referencedColumnName = "productId")
//	private Order order;
//	
//	
//	
//	
//	public Product(int productId, String productName, int productQuantity, Order order) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.productQuantity = productQuantity;
//		this.order = order;
//	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}
	public Product() {
		super();
	}
	public Product(int productId, String productName, int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	

}
