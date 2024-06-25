package com.vaibhav.springkafkaproducer.repo;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.springkafkaproducer.bean.Order;

public interface OrderCRUD extends CrudRepository<Order,Integer>{
	
	

}
