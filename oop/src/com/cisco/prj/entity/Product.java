package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

// meant only as generalization; but can't instantiate
@Table(name="products")
public abstract class Product  implements Comparable {
	private int id;
	private String name;
	private double price;
	
	public Product() {
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Column(name="PID", type="INTEGER")
	public int getId() {
		return id;
	}
	
	@Column(name="PRD_NAME")
	public String getName() {
		return name;
	}
	
	@Column(name="AMOUNT", type="DOUBLE")
	public double getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	public abstract boolean isExpensive();
	
	@Override
	public int compareTo(Object o) {
		Product other = (Product) o;
		return Double.compare(this.getPrice(), other.getPrice());
	}
}
