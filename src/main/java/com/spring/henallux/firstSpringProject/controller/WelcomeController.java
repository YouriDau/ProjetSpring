package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.CartItem;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({WelcomeController.CART})
public class WelcomeController {
    protected static final String CART = "cart";
    private ProductDataAccess productDAO;

    @Autowired
    public WelcomeController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @ModelAttribute(CART)
    public Cart setCart() {
        return new Cart();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value=CART) Cart cart, @RequestParam(required=false) String locale) {
        if(locale == "fr") {

        } else {

        }

        model.addAttribute("newProduct", new CartItem());
        model.addAttribute("products", productDAO.findAll());
        return "integrated:home";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFromData(Model model, @ModelAttribute(CART) Cart cart, @Valid @ModelAttribute(value="newProduct") CartItem item, final BindingResult errors) {
        String quantityMessage = "";
        if (!errors.hasErrors()) {
            cart.addItem(item);
        } else {
            quantityMessage = "The quantity must be more than 0";

        }
        model.addAttribute("message", quantityMessage);

        return "redirect:/home";
    }
}