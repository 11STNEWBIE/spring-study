/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }
}
