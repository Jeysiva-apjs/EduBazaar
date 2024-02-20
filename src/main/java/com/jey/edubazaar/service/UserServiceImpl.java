package com.jey.edubazaar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.edubazaar.entity.User;
import com.jey.edubazaar.exception.UserNotFoundException;
import com.jey.edubazaar.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public String loginUser(String name, String password) {
        List<User> users = (List<User>)userRepository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException(name);
        }
        User user = users.stream().filter(a -> a.getName().equals(name) 
        && a.getPassword().equals(password)).findFirst().orElse(null);

        if(user == null){
            throw new UserNotFoundException(name);   
        }

        return "Logged in successfully";
    }
}
