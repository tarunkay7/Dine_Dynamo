package com.project.dinedynamo.APIController;

import com.project.dinedynamo.Service.OTPService;
import com.project.dinedynamo.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserControllerAPI {

    @Autowired
    UserService userService;

    @Autowired
    OTPService otpService;

    @PostMapping("/createUser")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("rollNumber") String rollNumber,
            @RequestParam("phoneNumber") String phoneNumber
    ) {
        System.out.println("Creating user with name: " + name + ", roll number: " + rollNumber + ", and phone number: " + phoneNumber);

        userService.addUser(name, rollNumber, phoneNumber);
        return "redirect:/dashboard";
    }

    @GetMapping("/checkPhoneNumber")
    public ResponseEntity<Map<String, Boolean>> checkPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        boolean exists = userService.checkIfPhoneNumberExists(phoneNumber);
        if (exists) {
            // If the phone number exists, generate and send the OTP
            otpService.generateAndSendOTP(phoneNumber);
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verifyOTP")
    public RedirectView verifyOTP(
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("otp") String userOTP,
            HttpServletRequest request
    ) {

        if (otpService.verifyOTP(phoneNumber, userOTP)) {
            System.out.println("OTP verified successfully");

            //start a session
            HttpSession session = request.getSession();
            session.setAttribute("phoneNumber", phoneNumber);


            return new RedirectView("/dashboard");
        } else {
            System.out.println("Invalid OTP");
            return new RedirectView("/login");
        }
    }
    }


