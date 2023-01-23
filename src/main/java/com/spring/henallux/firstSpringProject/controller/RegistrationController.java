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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String getFormData(Model model, @Valid @ModelAttribute(value="registration") User form, final BindingResult errors) {
        if(!errors.hasErrors()) {
            // verify the phone number
            String regexPhoneNumber = "^(\\+[1-9]{1,3}|0)[-. ]?([0-9]{3})([-. ]?([0-9]{2})){3}$";
            Pattern pattern = Pattern.compile(regexPhoneNumber);
            Matcher matcher = pattern.matcher(form.getPhoneNumber());

            boolean userExists = userDAO.userExists(form.getUsername());
            boolean emailExists = userDAO.emailExists(form.getEmail());
            boolean phoneNumberIsCorrect = matcher.matches();

            if (!userExists && !emailExists && phoneNumberIsCorrect) {
                BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
                String passwordHashed = crypt.encode(form.getPassword());

                User user = new User( form.getUsername(),
                                      passwordHashed,
                                      form.getLastName(),
                                      form.getFirstName(),
                                      (form.getBirthDate().isEmpty()? null : form.getBirthDate()),
                                      form.getEmail(),
                                      form.getPhoneNumber(),
                                      form.getAddress(),
                                      (form.getTvaNumber().isEmpty()?null:form.getTvaNumber()),
                                      "ROLE_USER",
                                      true,
                                      true,
                                      true,
                                      true);

                userDAO.addUser(user);
                return "redirect:/home";
            } else {
                if (userExists)
                    model.addAttribute("usernameError", "This username is already existing!");
                if (emailExists)
                    model.addAttribute("emailError", "This email is already takenThis username is already existing!");
                if (!phoneNumberIsCorrect)
                    model.addAttribute("phoneNumberError", "The phone number must be like (+32 471 11 22 33) or (0471 11 22 33)");
                return "integrated:registration";
            }
        } else {
            return "integrated:registration";
        }
    }
}
