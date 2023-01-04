package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({WelcomeController.CART, WelcomeController.LOCALE})
public class WelcomeController {
    protected static final String CART = "cart";
    protected static final String LOCALE = "locale";
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;
    private ArrayList<Product> productsToDisplay;

    @Autowired
    public WelcomeController(ProductDAO productDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
        productsToDisplay = new ArrayList<>();
    }

    @ModelAttribute(CART)
    public Cart cart() {
        return new Cart();
    }

    @ModelAttribute(LOCALE)
    public Locale locale() { return new Locale("en");}

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value=CART) Cart cart, @ModelAttribute(value=LOCALE) Locale locale, @RequestParam(required=false) String newLocale) {
        productsToDisplay = productDAO.findAll();

        if(newLocale != null) {
            locale.setLocale(newLocale);
        }

        model.addAttribute("categoryChoosen", new Category());
        model.addAttribute("categories", categoryDAO.findAllByLocale(locale.getLocale()));
        model.addAttribute("products", productsToDisplay);
        return "integrated:home";
    }

    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String getCategoryFromData(Model model, @ModelAttribute(value="categoryChoosen") Category category, @ModelAttribute(value=CART) Cart cart,
                                      @ModelAttribute(value=LOCALE) Locale locale) {

        if (category.getLabel().compareTo("all") == 0) {
            productsToDisplay = productDAO.findAll();
        } else {
            productsToDisplay = productDAO.findByTranslationLabel(category.getLabel());
        }


        model.addAttribute("categoryChoosen", new Category());
        model.addAttribute("categories", categoryDAO.findAllByLocale(locale.getLocale()));
        model.addAttribute("products", productsToDisplay);
        return "integrated:/home";
    }
}