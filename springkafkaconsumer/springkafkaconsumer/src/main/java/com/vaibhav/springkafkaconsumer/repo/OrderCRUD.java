package com.vaibhav.springkafkaconsumer.repo;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.springkafkaconsumer.bean.Order;

public interface OrderCRUD extends CrudRepository<Order,Integer>{
	
	

}
