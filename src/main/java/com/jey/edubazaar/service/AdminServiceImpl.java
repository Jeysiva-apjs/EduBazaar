package com.jey.edubazaar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.edubazaar.entity.Admin;
import com.jey.edubazaar.exception.AdminNotFoundException;
import com.jey.edubazaar.repository.AdminRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    AdminRepository adminRepository;

    @Override
    public String createAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin created successfully";
    }

    @Override
    public String loginAdmin(String name, String password) {
        List<Admin> admins = (List<Admin>)adminRepository.findAll();
        if(admins.isEmpty()){
            throw new AdminNotFoundException(name);
        }
        Admin admin = admins.stream().filter(a -> a.getName().equals(name) 
        && a.getPassword().equals(password)).findFirst().orElse(null);

        if(admin == null){
            throw new AdminNotFoundException(name);
        }
        return "Logged in successfully";
    }
    
}
