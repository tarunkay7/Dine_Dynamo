package com.project.dinedynamo.Controller;

import com.project.dinedynamo.Entities.Items;
import com.project.dinedynamo.Entities.User;
import com.project.dinedynamo.Service.ItemsService;
import com.project.dinedynamo.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.lang.annotation.Repeatable;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebViewController {

    @Autowired
    UserService userService;

    @Autowired
    ItemsService itemsService;




    @GetMapping("/signup")
    public String signuppage() {
        return "signup"; // Return the name of the HTML file (without the extension)
    }

    @GetMapping("/login")
    public String loginpage() {
        return "login"; // Return the name of the HTML file (without the extension)
    }

    // Define other view-related endpoints as needed
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        // get the phone number from the session
        String phoneNumber = (String) session.getAttribute("phoneNumber");

        // get the user by phone number
        User user = userService.getUserByPhoneNumber(phoneNumber);

        List<Items> items = itemsService.getAllItems();

        // add the user attributes to the model
        model.addAttribute("name", user.getName());
        model.addAttribute("rollNumber", user.getRollNumber());
        model.addAttribute("items", items);
        return "dashboard";
    }

    @GetMapping("/testdashboard")
    public String testdashboard(HttpSession session,Model model)
    {
        List<Items> items = itemsService.getAllItems();
        model.addAttribute("items",items);
        return "testdashboard";
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        // get the session and invalidate it
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // redirect to the login page
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String homepage() {
        return "home"; // Return the name of the HTML file (without the extension)
    }
}
