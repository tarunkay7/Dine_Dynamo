package com.project.dinedynamo.Service;

import com.project.dinedynamo.Entities.User;
import com.project.dinedynamo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userrepository;

    @Autowired
    OTPService otpService;

    public void addUser(String name, String rollNumber, String phoneNumber ) {
        User user = new User(name, rollNumber, phoneNumber);
        userrepository.save(user);
    }

    public User getUserDetailsByName(String name) {
        return userrepository.findByName(name);
    }

    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    public boolean checkIfPhoneNumberExists(String phoneNumber) {
        return userrepository.existsByPhoneNumber(phoneNumber);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userrepository.findByPhoneNumber(phoneNumber);
    }
}

