package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class WelcomeController {
    private ProductDataAccess productDAO;

    @Autowired
    public WelcomeController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("products", productDAO.findAll());
        return "integrated:welcome";
    }
}
