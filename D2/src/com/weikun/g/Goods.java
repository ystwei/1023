package com.weikun.g;

import java.io.Serializable;

public class Goods implements Serializable {
	//JavaBean
	
	private String name;
	public Goods(String name, double price, int quantity, String no) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.no = no;
	}
	private double price;
	private int quantity;
	private String no;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
}
