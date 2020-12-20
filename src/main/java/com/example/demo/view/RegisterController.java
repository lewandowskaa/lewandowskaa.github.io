package com.example.demo.view;

import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("register")
    public ModelAndView register(String firstName, String lastName, String email, String password1, String password2, Model model) {
        return registerService.registerResponse(firstName, lastName, email, password1, password2, model);
    }
}
