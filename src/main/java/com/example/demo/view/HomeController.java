package com.example.demo.view;

import com.example.demo.service.DogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private DogServices dogServices;

    @GetMapping("home")
    public ModelAndView home(Model model) {
        model.addAttribute("dogList", dogServices.findAll());
        return new ModelAndView("home");
    }
}
