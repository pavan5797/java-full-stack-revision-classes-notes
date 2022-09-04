package com.ecommerce.model;

public class Product {
	private int id;
	private String name;
	private float price;
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Product(int id, String name, float price, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}

	public Product() {
		super();
	}

}
