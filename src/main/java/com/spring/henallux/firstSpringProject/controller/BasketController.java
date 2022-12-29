package com.spring.henallux.firstSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/basket")
public class BasketController {
    @RequestMapping(method=RequestMethod.GET)
    public String basket(Model model) {
        return "integrated:basket";
    }
}
