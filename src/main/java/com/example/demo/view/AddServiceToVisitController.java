package com.example.demo.view;

import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddServiceToVisitController {

//    klasa kontroller odpowiedzialana za wystawienie endpointu pod ktory uzytkownik moze wyslac request | zwraca uzytkownikowi odpowiedni html

    @Autowired
    private VisitServices visitServices;

    @PostMapping("addServiceToVisit")
    public ModelAndView orderVisit(Integer dogId, Integer dogServiceId, Integer visitId) {
        visitServices.addDogServiceToVisit(dogServiceId, visitId);
        return new ModelAndView("redirect:orderVisit", "dogId", dogId);
    }
}
