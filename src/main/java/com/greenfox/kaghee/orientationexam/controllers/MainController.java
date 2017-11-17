package com.greenfox.kaghee.orientationexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"", "/"})
    public String loadMain() {

        return "main";
    }
}
