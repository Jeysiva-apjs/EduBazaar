package com.jey.edubazaar.service;

import com.jey.edubazaar.entity.Admin;

public interface AdminService {
    String createAdmin(Admin admin); 
    String loginAdmin(String email, String password);  
} 
