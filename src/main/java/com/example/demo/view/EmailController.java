package com.example.demo.view;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    //    klasa kontroller odpowiedzialana za wystawienie endpointu pod ktory uzytkownik moze wyslac request | zwraca uzytkownikowi odpowiedni html

    @Autowired
    private EmailService emailService;

    @PostMapping("sendEmail")
    public ModelAndView sendEmail(String firstName, String email, String phone, String context) {
        emailService.sendEmail(firstName, email, phone, context);
        return new ModelAndView("redirect:home");
    }
}
