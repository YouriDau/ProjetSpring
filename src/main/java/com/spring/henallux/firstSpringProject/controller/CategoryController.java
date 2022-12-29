package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/category")
public class CategoryController {

    @RequestMapping(value="/send", method= RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="category") User form) {
        return "redirect:/home";
    }
}
