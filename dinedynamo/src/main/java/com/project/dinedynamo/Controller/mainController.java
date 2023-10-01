package com.project.dinedynamo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class mainController {
    @GetMapping("/items")
    public String showMessage(Model model) {
        return "items";
    }
    @GetMapping("/my-page")
    public String myPage(Model model) {
        return "home"; // This corresponds to "home.html"
    }
}
