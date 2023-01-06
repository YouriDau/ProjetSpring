package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.CartItem;
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

    @RequestMapping(value="/paymentCancelled", method=RequestMethod.GET)
    public String paymentCancelled(Model model, @ModelAttribute("cart") Cart cart) {
        String errorMessage = "Your payment has been cancelled!";

        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute(cart);
        model.addAttribute("cartItem", new CartItem());

        return "integrated:cart";
    }

    @RequestMapping(value="/paymentSuccess", method=RequestMethod.GET)
    public String paymentSuccess(Model model, @ModelAttribute("cart") Cart cart) {


        cart.getItems().clear();
        String successMessage = "Your payment has been validated!";
        model.addAttribute("successMessage", successMessage);
        return "integrated:cart";
    }
}
