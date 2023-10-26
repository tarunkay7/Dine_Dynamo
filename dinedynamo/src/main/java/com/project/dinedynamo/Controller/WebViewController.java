package com.project.dinedynamo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    @GetMapping("/signup")
    public String signuppage() {
        return "signup"; // Return the name of the HTML file (without the extension)
    }

    @GetMapping("/login")
    public String loginpage() {
        return "login"; // Return the name of the HTML file (without the extension)
    }

    // Define other view-related endpoints as needed
}
