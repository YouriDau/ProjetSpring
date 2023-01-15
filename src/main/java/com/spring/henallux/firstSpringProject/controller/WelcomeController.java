package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.dao.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({WelcomeController.CART})
public class WelcomeController {
    protected static final String CART = "cart";
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;
    private PromotionDataAccess promotionDAO;
    private ArrayList<Product> productsToDisplay;

    @Autowired
    public WelcomeController(ProductDAO productDAO, CategoryDAO categoryDAO, PromotionDAO promotionDAO) {
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
        this.promotionDAO = promotionDAO;
        productsToDisplay = new ArrayList<>();
    }

    @ModelAttribute(CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value=CART) Cart cart, java.util.Locale locale) {

        productsToDisplay = productDAO.findAll();

        Promotion promotion;
        for(Product product : productsToDisplay) {
            promotion = promotionDAO.findByProductId(product.getId());
            if (promotion != null) {
                product.setPromotion(promotion);
            }
        }

        System.out.println(locale.getLanguage());

        model.addAttribute("categoryChoosen", new Category());
        model.addAttribute("categories", categoryDAO.findAllByLocale(locale.getLanguage()));
        model.addAttribute("products", productsToDisplay);
        return "integrated:home";
    }

    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String getCategoryFromData(Model model, @ModelAttribute(value="categoryChoosen") Category category, @ModelAttribute(value=CART) Cart cart,
                                      Locale locale) {

        if (category.getLabel().compareTo("all") == 0) {
            productsToDisplay = productDAO.findAll();
        } else {
            productsToDisplay = productDAO.findByTranslationLabelAndTranslationLanguageId(category.getLabel(), locale.getLanguage());
        }

        Promotion promotion;
        for(Product product : productsToDisplay) {
            promotion = promotionDAO.findByProductId(product.getId());
            if (promotion != null) {
                product.setPromotion(promotion);
            }
        }

        model.addAttribute("categoryChoosen", new Category());
        model.addAttribute("categories", categoryDAO.findAllByLocale(locale.getLanguage()));
        model.addAttribute("products", productsToDisplay);
        return "integrated:/home";
    }
}