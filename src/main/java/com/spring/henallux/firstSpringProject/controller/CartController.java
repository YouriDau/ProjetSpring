package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.CartItem;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({"cart"})
public class CartController {

    @RequestMapping(method=RequestMethod.GET)
    public String basket(Model model, @ModelAttribute("cart") Cart cart) {
        model.addAttribute(cart);
        model.addAttribute("cartItem", new CartItem());
        return "integrated:cart";
    }

    @RequestMapping(value="/removeItem/{name}", method=RequestMethod.GET)
    public String basketRemoveItem(@PathVariable String name, @ModelAttribute("cart") Cart cart) {
        cart.getItems().remove(name);
        return "redirect:/cart";
    }

    @RequestMapping(value="/sendQuantity", method=RequestMethod.POST)
    public String changeQuantity(@ModelAttribute("cart") Cart cart, @ModelAttribute("cartItem") CartItem cartItem) {
        cart.getItems().get(cartItem.getName()).setQuantity(cartItem.getQuantity());
        return "integrated:cart";
    }

    @RequestMapping(value="/sendRemoveItem", method=RequestMethod.POST)
    public String removeItem(@ModelAttribute("cart") Cart cart, @ModelAttribute("cartItem") CartItem cartItem) {
        cart.getItems().remove(cartItem.getName());

        return "integrated:cart";
    }
}
