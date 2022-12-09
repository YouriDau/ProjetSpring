package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/authenticated")
public class AuthenticatedController {

    @RequestMapping(method= RequestMethod.GET)
    public String authenticated(Authentication authentication) {
        User userDetails = (User) authentication.getPrincipal();
        if(userDetails != null) {
            System.out.println("User has name: " + userDetails.getUsername());
            System.out.println("User has authorities: " + userDetails.getAuthorities());
        }
        return "integrated:authenticated";
    }
}
