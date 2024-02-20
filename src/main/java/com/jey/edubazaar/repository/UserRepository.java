package com.jey.edubazaar.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.edubazaar.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    
} 
