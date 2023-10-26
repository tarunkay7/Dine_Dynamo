package com.project.dinedynamo.Service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Autowired
    SMSService smsService;
    public void generateAndSendOTP(String phoneNumber) {
        // Generate an OTP (you can use a library like Apache Commons Text to generate random OTPs)
        String otp = generateRandomOTP();

        // Send the OTP to the provided phone number using a SMS service or other means
        sendOTP(phoneNumber, otp);
    }

    private String generateRandomOTP() {
        return RandomStringUtils.randomNumeric(6);
    }

    private void sendOTP(String phoneNumber, String otp) {
        String message = "Your OTP is: " + otp;
        smsService.sendSMS(phoneNumber, message);
    }
}
