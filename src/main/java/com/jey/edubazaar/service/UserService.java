package com.jey.edubazaar.service;

import com.jey.edubazaar.entity.User;

public interface UserService {
    String createUser(User user);
    String loginUser(String email, String password);  
}
