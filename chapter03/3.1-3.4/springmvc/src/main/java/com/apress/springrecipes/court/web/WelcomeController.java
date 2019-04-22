package com.apress.springrecipes.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {

        Date today = new Date();
        model.addAttribute("today",today);
        return "welcome";
    }
}
