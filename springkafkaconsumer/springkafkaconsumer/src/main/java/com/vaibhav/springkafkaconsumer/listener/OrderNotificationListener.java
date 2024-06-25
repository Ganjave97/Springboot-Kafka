package com.vaibhav.springkafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav.springkafkaconsumer.bean.Order;
import com.vaibhav.springkafkaconsumer.bean.User;
import com.vaibhav.springkafkaconsumer.repo.OrderCRUD;
import com.vaibhav.springkafkaconsumer.repo.UserCRUD;

@Service
public class OrderNotificationListener {
	
	ObjectMapper om=new ObjectMapper();
	
	@Autowired
	OrderCRUD orderCRUD;
	
	@Autowired
	 UserCRUD userCRUD;
	
	@KafkaListener(topics = "order-topic", groupId = "groupId")
	public void processOrder(String message) {
		System.out.println("Received Message:"+message);
		
		try {
		Order order =om.readValue(message,Order.class);
		User user=userCRUD.findById(order.getUserId()).get();
		if(user.getBalance()>order.getOrderAmount()) {
			order.setStatus("SUCCESS");
			user.setBalance(user.getBalance()-order.getOrderAmount());
			userCRUD.save(user);
		}
		orderCRUD.save(order);
	}catch(JsonProcessingException e) {
		e.printStackTrace();
	}

  }
}
