package com.example.demo.view;

import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRemoveVisitController {

    @Autowired
    private VisitServices visitServices;

    @PostMapping("userRemoveVisit")
    public ModelAndView removeVisit(Integer visitId) {
        visitServices.removeVisit(visitId);
        return new ModelAndView("redirect:visitList");
    }
}
