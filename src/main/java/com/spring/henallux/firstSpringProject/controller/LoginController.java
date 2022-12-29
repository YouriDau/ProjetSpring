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
@RequestMapping(value="/login")
public class LoginController {
    private UserDataAccess userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("login", new User());
        return "integrated:login";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="login") User form) {
        System.out.println(form.getUsername() + "  " + form.getPassword());
        return "redirect:/home";
    }

   /*
   <form method="POST">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
        ${param.error}
    <c:if test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
        <div class="error">
                ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </c:if>
</form>

    */
}
