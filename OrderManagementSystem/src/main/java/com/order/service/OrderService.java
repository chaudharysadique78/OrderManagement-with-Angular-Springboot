package com.order.service;

import java.util.List;

import com.order.entity.Order;


public interface OrderService {

	public Order createOrder(Order order);

	public Order getOrder(int id);

	public List<Order> getAllOrder();
	
	public void deleteOrder(int id);
	
	public int updateOrder(Order order,int id);

}
