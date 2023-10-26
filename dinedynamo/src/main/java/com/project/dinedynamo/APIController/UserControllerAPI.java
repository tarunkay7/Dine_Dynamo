package com.project.dinedynamo.APIController;

import com.project.dinedynamo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserControllerAPI {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("rollNumber") String rollNumber,
            @RequestParam("phoneNumber") String phoneNumber
    ) {
        System.out.println("Creating user with name: " + name + ", roll number: " + rollNumber + ", and phone number: " + phoneNumber);

        userService.addUser(name, rollNumber, phoneNumber);
        return "User created successfully!";
    }

    @GetMapping("/checkPhoneNumber")
    public ResponseEntity<Map<String, Boolean>> checkPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        boolean exists = userService.checkIfPhoneNumberExists(phoneNumber);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }


}
