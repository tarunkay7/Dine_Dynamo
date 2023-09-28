package com.project.dinedynamo.APIController;

import com.project.dinedynamo.Entities.User;
import com.project.dinedynamo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerAPI {

    @Autowired
    UserService userservice;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userservice.addUser(user);
    }

    @GetMapping("/getUserDetailsByName")
    public User getUserDetailsByName(@RequestParam String name) {
        return userservice.getUserDetailsByName(name);

    }
}



