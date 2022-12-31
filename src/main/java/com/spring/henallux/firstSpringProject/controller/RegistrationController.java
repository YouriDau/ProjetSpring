package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    public String getFormData(@Valid @ModelAttribute(value="registration") User form, final BindingResult errors) {
        if(!errors.hasErrors()) {
            BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
            String passwordHashed = crypt.encode(form.getPassword());
            User user = new User(form.getUsername(), passwordHashed, form.getLastName(), form.getFirstName(), form.getBirthDate(), form.getEmail(), form.getPhoneNumber(), form.getAddress(), form.getTvaNumber(), "ROLE_USER", true, true, true, true);

            System.out.println(form.getUsername());
            userDAO.addUser(user);
            return "redirect:/home";
        } else {
            return "integrated:registration";
        }
    }
}
