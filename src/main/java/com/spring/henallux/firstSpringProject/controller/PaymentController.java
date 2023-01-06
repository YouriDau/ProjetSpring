package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/payment")
@SessionAttributes({"cart"})
public class PaymentController {
    @RequestMapping(method= RequestMethod.GET)
    public String payment(Model model, @ModelAttribute("cart")Cart cart) {
        model.addAttribute(cart);
        return "integrated:payment";
    }
}
