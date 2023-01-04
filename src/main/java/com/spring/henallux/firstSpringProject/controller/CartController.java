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
        String name = cartItem.getProduct().getName();
        Integer quantity = cartItem.getQuantity();

        if (quantity <= 0) {
            cart.getItems().remove(name);
        } else {
            cart.getItem(name).setQuantity(quantity);
        }

        return "integrated:cart";
    }
}
