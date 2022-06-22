package com.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderServiceImpl;

@SpringBootTest
class OrderManagementSystemApplicationTests {
	@MockBean
	OrderRepository orderRepository;
	@Autowired
	private OrderServiceImpl orderService;

//	@Test
//	void testRegister() {
//		Order order = new Order();
//		Order savedOrder = new Order();
//		savedOrder.setId(101);
//		when(orderRepository.save(order)).thenReturn(savedOrder);
//		Order outputOrder = controller.saveOrder(order);
//		System.out.println(outputOrder);
//		assertNotNull(outputOrder);
//		assertNotNull(outputOrder.getId());
//		assertEquals(101, outputOrder.getId());
//		verify(orderRepository).save(order);
//	}

	@Test
	void testRegister() throws Exception {
		Order order = new Order(2, "Mobile", 155, "Samsung");
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.createOrder(order));
		verify(orderRepository).save(order);
	}
	
	@Test
	public void getAllOrder() throws Exception {
		when(orderRepository.findAll()).thenReturn(Stream.of(new Order(11,"Mobile",10000.0,"Samsung"),new Order(12,"Laptop",20000.0,"Acer")).collect(Collectors.toList()));
		assertEquals(2, orderService.getAllOrder().size());
	}
	
	@Test
	public void getOrder() {
		Order order = new Order(11,"Mobile",10000.0,"Samsung");
		when(orderRepository.findById(11)).thenReturn(Optional.of(order));
		assertEquals(order, orderService.getOrder(11));
	}
	
	@Test
	public void testDelete() {
		doNothing().when(orderRepository).deleteById(1);
		orderService.deleteOrder(1);
		verify(orderRepository).deleteById(1);
	}

}
