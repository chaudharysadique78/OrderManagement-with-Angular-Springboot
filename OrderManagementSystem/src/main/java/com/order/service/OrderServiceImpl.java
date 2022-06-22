package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.exception.ResourceNotFoundException;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		Order saveOrder = orderRepository.save(order);
		return saveOrder;
	}

	@Override
	public Order getOrder(int id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public int updateOrder(Order order, int id) {
		Order exsistingOrder = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order", "id", id));
		exsistingOrder.setOrderName(order.getOrderName());
		exsistingOrder.setOrderPrice(order.getOrderPrice());
		exsistingOrder.setBrand(order.getBrand());
		orderRepository.save(exsistingOrder);
		return exsistingOrder.getId();
	}

}
