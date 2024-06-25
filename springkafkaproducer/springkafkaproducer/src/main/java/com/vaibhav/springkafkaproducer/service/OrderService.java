package com.vaibhav.springkafkaproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav.springkafkaproducer.bean.Order;
import com.vaibhav.springkafkaproducer.controller.OrderController;
import com.vaibhav.springkafkaproducer.repo.OrderCRUD;

@Service
public class OrderService {
	
	
	@Autowired
	OrderCRUD orderCRUD;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate; 
	
	@Value("${order.topic.name}")
	private String topicName;
	
	ObjectMapper om=new ObjectMapper();
	
	public Order saveOrder(Order order) {
		order.setStatus("CREATED");
		order=orderCRUD.save(order);
		String message=null;
		try {
			message=om.writeValueAsString(order);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public List<Order> getOrders(){
		List<Order> orders=(List<Order>) orderCRUD.findAll();
		return orders;
	}

}
