package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/basket")
@SessionAttributes({"basket"})
public class BasketController {
    @RequestMapping(method=RequestMethod.GET)
    public String basket(Model model, @ModelAttribute("basket")Basket basket) {
        model.addAttribute(basket);
        return "integrated:basket";
    }
}
