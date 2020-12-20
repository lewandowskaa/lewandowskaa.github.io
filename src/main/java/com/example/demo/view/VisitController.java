package com.example.demo.view;

import com.example.demo.service.DogServices;
import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class VisitController {

    @Autowired
    private VisitServices visitServices;

    @Autowired
    private DogServices dogservices;

    @GetMapping("orderVisit")
    public ModelAndView visit(HttpServletRequest request, Integer dogId, String message, String messageType, Model model) {
        model.addAttribute("dog", dogservices.findById(dogId));
        model.addAttribute("visit", visitServices.visitInPreparation(request));
        model.addAttribute("minDate", LocalDate.now().plusDays(1).toString());
        model.addAttribute("message", message);
        model.addAttribute("messageType", messageType);
        return new ModelAndView("orderVisit");
    }

    @PostMapping("orderVisit")
    public ModelAndView orderVisit(HttpServletRequest request, Integer dogId, Integer visitId, String date, String time) {
        return visitServices.orderVisitResponse(request, dogId, visitId, date, time);
    }
}
