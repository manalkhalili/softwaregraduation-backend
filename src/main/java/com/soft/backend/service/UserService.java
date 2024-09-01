package com.soft.backend.service;

import com.soft.backend.entity.UserInfo;
import com.soft.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserInfo registerUser(UserInfo user) throws Exception {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new Exception("Email is already registered.");
        }
        return userRepo.save(user);
    }
    public UserInfo signInUser(String email, String password) {
        UserInfo user = userRepo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }


    public List<UserInfo> getAllUsers() {
        return userRepo.findAll();
    }

    public List<UserInfo> getUsersByName(String name) {
        return userRepo.findByName(name);
    }

    public UserInfo getUserByPhoneNumber(String phoneNumber) {
        return userRepo.findByPhoneNumber(phoneNumber);
    }

    public UserInfo getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public boolean checkIfEmailExists(String email) {
        return userRepo.existsByEmail(email);
    }
}
