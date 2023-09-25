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

    public User addUser(User user) {
        user.setAdmin(false);
        return userrepository.save(user);
    }
    public User getUserDetailsByName(String name) {
        return userrepository.findByName(name);
    }

    public List<User> getAllUsers() {
        return userrepository.findAll();
    }
}
