package com.example.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "id")
	private int product_id;
	
	@Column(name = "name")
	private String product_name;
	
	@Column(name = "company")
	private String product_company;
	
	@Column(name = "price")
	private String product_price;
	
	@Column(name = "lunched")
	private boolean product_lunched;

	public Product(int product_id, String product_name, String product_company, String product_price,
			boolean product_lunched) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_company = product_company;
		this.product_price = product_price;
		this.product_lunched = product_lunched;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_company() {
		return product_company;
	}

	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public boolean isProduct_lunched() {
		return product_lunched;
	}

	public void setProduct_lunched(boolean product_lunched) {
		this.product_lunched = product_lunched;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_company="
				+ product_company + ", product_price=" + product_price + ", product_lunched=" + product_lunched + "]";
	}
	
	
	

	

	
	

}
