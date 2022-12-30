package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({WelcomeController.BASKET})
public class WelcomeController {
    protected static final String BASKET = "basket";
    private ProductDataAccess productDAO;

    @Autowired
    public WelcomeController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @ModelAttribute(BASKET)
    public Basket setBasket() {
        return new Basket();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value=BASKET) Basket basket) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("products", productDAO.findAll());
        return "integrated:welcome";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFromData(@ModelAttribute(BASKET) Basket basket, @ModelAttribute(value="newProduct") Product form) {
        basket.addItem(form);
        return "redirect:/home";
    }
}