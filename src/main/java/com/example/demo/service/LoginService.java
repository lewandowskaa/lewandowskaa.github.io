package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {

    // servis odpowiedzialny za prawidlowe logowanie uzytkownika | jesli dane email & password sa prawidlowe uzytkownikowi zostaje nadana sesja
    // uprawnia go ona do swobodnego poruszania sie po aplikacji i korzystanie z funkcjonalnosci przeznaczonych do roli uzytkownika w aplikacji

    @Autowired
    private UserService userService;

    public String loggedEmail(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("email");
    }

    public User login(HttpServletRequest request, String email, String password) {
        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("email", user.getEmail());
            return user;
        }
        return null;
    }

    public ModelAndView loginResponse(HttpServletRequest request, String email, String password, Model model) {
        User user = login(request, email, password);

        if (user != null)
            return user.getUserRole().equals(UserRole.USER) ? new ModelAndView("redirect:home") : new ModelAndView("redirect:adminVisitList");

        model.addAttribute("message", "Dane nieprawidłowe");
        model.addAttribute("messageType", "danger");
        return new ModelAndView("login");
    }
}
