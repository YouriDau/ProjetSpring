package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.PromotionDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.PromotionDataAccess;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/product")
@SessionAttributes({"cart"})
public class ProductController {
    private ProductDataAccess productDAO;
    private PromotionDataAccess promotionDAO;
    private Product product;

    @Autowired
    public ProductController(ProductDAO productDAO, PromotionDAO promotionDAO) {
        this.productDAO = productDAO;
        this.promotionDAO = promotionDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String product(Model model, @RequestParam(required=false) String name) {
        product = productDAO.findByName(name);
        Promotion promotion = promotionDAO.findByProductId(product.getId());

        if (promotion != null) {
            product.setPromotion(promotion);
        }
        model.addAttribute(product);
        model.addAttribute("newItem", new CartItem());
        return "integrated:product";
    }

    @RequestMapping(value="/addItem", method=RequestMethod.POST)
    public String getFromData(Model model, @ModelAttribute("cart") Cart cart,
                              @Valid @ModelAttribute(value="newItem") CartItem item, final BindingResult errors) {

        if (!errors.hasErrors()) {
            cart.addItem(item);
        }
        model.addAttribute(product);
        return "integrated:product";
    }
}
