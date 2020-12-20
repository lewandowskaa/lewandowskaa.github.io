package com.example.demo.view;

import com.example.demo.service.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VisitListController {

    @Autowired
    private VisitServices visitServices;

    @GetMapping("visitList")
    public ModelAndView visitList(HttpServletRequest request) {
        return new ModelAndView("visitList", "visitList", visitServices.visitList(request));
    }
}
