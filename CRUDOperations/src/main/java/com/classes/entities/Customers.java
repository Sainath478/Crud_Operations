package com.classes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cus_id;
	private String cus_name;
	private String product_name;
	private int product_price;
	
	public Customers() {
	}

	@Override
	public String toString() {
		return "Customers [cus_id=" + cus_id + ", cus_name=" + cus_name + ", product_name=" + product_name
				+ ", product_price=" + product_price + "]";
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public Customers(int cus_id, String cus_name, String product_name, int product_price) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.product_name = product_name;
		this.product_price = product_price;
	}

}
