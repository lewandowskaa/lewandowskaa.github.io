package com.example.demo.view;

import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RemoveDogServiceController {

    @Autowired
    private VisitServices visitServices;

    @PostMapping("removeDogService")
    public ModelAndView removeDogService(Integer dogId, Integer visitId, Integer dogServiceId) {
        visitServices.removeDogServiceFromVisit(visitId, dogServiceId);
        return new ModelAndView("redirect:orderVisit", "dogId", dogId);
    }
}
