package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderServiceImpl;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/saveorder")
	public Order saveOrder(@RequestBody Order order) {
		Order saveOrder = orderService.createOrder(order);
		return saveOrder;
	}

	@GetMapping("/findorder/{id}")
	public Order getOrder(@PathVariable int id) {
		return orderService.getOrder(id);
	}

	@GetMapping("/findallorder")
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int id) {
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(HttpStatus.OK);
		try {
			orderService.deleteOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PutMapping("/updateorder/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(HttpStatus.OK).;
		try {
			orderService.updateOrder(order, id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity=new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
