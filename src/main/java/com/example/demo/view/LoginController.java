package com.example.demo.view;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("login")
    public ModelAndView loginPost(HttpServletRequest request, String email, String password, Model model) {
        return loginService.loginResponse(request, email, password, model);
    }
}
