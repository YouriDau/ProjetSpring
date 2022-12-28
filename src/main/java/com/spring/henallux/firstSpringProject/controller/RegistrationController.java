package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
    private UserDataAccess userDAO;

    @Autowired
    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("registration", new User());
        return "integrated:registration";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="registration") User form) {
        //User user = new User(form.getUsername(), form.getPassword(), form.getLastName(), form.getFirstName(), form.getBirthDate(), form.getEmail(), form.getPhoneNumber(), form.getAddress(), form.getTvaNumber(), "ROLE_USER", true, true, true, true);
        form.setAccountNonExpired(true);
        form.setAccountNonLocked(true);
        form.setCredentialsNonExpired(true);
        form.setEnabled(true);
        System.out.println(form.getUsername());
        userDAO.addUser(form);
        return "redirect:/home";
    }
}
