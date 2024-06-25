package com.vaibhav.springkafkaproducer.repo;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.springkafkaproducer.bean.User;

public interface UserCRUD extends CrudRepository<User, Integer>{

}
