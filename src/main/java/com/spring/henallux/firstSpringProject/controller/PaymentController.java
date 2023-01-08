package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderLineDataAccess;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.CartItem;
import com.spring.henallux.firstSpringProject.model.Order;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value="/payment")
@SessionAttributes({"cart"})
public class PaymentController {
    private OrderDataAccess orderDAO;
    private OrderLineDataAccess orderLineDAO;

    @Autowired
    public PaymentController(OrderDAO orderDAO, OrderLineDAO orderLineDAO) {
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String payment(Model model, @ModelAttribute("cart")Cart cart, Authentication authentication) {
        User user = (User)authentication.getPrincipal();

        Order newOrder = new Order();
        ArrayList<CartItem> cartItems = new ArrayList<>(cart.getItems().values());
        newOrder.setUserPseudo(user.getUsername());
        orderDAO.saveOrder(newOrder);
        orderLineDAO.saveCartItems(cartItems, user.getUsername());

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
    public String paymentSuccess(Model model, @ModelAttribute("cart") Cart cart, Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        orderDAO.updateOrderIsPaid(true, user.getUsername());


        cart.getItems().clear();
        String successMessage = "Your payment has been validated!";
        model.addAttribute("successMessage", successMessage);
        return "integrated:cart";
    }
}
