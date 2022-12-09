package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.core.Authentication;

@Controller
@RequestMapping(value="/admin")
public class AdminController {


    /*private UserRepository userRepository;

    @Autowired
    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @RequestMapping(method= RequestMethod.GET)
    public String home() {
        return "integrated:admin";
    }

   /* @RequestMapping(method= RequestMethod.GET)
    public String home(Authentication authentication) {
        User userDetails = (User) authentication.getPrincipal();


        System.out.println("User has name: " + userDetails.getUsername());
        System.out.println("User has authorities: " + userDetails.getAuthorities());


        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String password = encoder.encode("chef");

        //UserEntity newUser = new UserEntity("Chef",password,"ROLE_USER",true,true,true,true);
      //  userRepository.save(newUser);

        return "integrated:admin";
    }*/
}
