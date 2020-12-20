package com.example.demo.view;

import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminVisitListController {

    //    klasa kontroller odpowiedzialana za wystawienie endpointu pod ktory uzytkownik moze wyslac request | zwraca uzytkownikowi odpowiedni html

    @Autowired
    private VisitServices visitServices;

    @GetMapping("adminVisitList")
    public ModelAndView adminVisitList(Model model) {
        model.addAttribute("visitList", visitServices.findAllByStatusOrderByDate());
        return new ModelAndView("adminVisitList");
    }
}
