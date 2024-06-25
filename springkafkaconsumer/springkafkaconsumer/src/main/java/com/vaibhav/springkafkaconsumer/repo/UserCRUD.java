package com.vaibhav.springkafkaconsumer.repo;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.springkafkaconsumer.bean.User;

public interface UserCRUD extends CrudRepository<User, Integer>{

}
