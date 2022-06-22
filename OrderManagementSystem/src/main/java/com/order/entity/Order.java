package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_entity")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orderName;
	private double orderPrice;
	private String brand;
	
	public Order() {
		super();
	}

	public Order(int id, String orderName, double orderPrice, String brand) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", orderPrice=" + orderPrice + ", brand=" + brand + "]";
	}
     
}
