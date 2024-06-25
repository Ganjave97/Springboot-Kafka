package com.vaibhav.springkafkaproducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.springkafkaproducer.bean.Order;
import com.vaibhav.springkafkaproducer.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/all")
	public List<Order> getOrders() {
		return orderService.getOrders();
		
	}
	@PostMapping("/create")
	public Order saveOrder(@RequestBody Order order) {
		
		
		return orderService.saveOrder(order);
	}

}
