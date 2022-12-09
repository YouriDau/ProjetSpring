package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {
    /*@RequestMapping(method= RequestMethod.GET) // si formulaire html et non form:form
    public String login() {
        return "integrated:login";
    }*/

    @RequestMapping(method= RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "integrated:login";
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
