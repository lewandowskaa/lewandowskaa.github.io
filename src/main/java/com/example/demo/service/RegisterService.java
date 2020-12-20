package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Service
public class RegisterService {

    // serwis przechowujacy logike pozwalajaca na rejestracje nowego uzytkownika

    @Autowired
    private UserService userService;

    public boolean registerNewUser(String firstName, String lastName, String email, String password1, String password2) {
        if (emailExist(email)) return false;
        if (isPasswordsAreDifferent(password1, password2)) return false;

        User user = new User(null, firstName, lastName, email, password1, UserRole.USER, Collections.emptyList());
        userService.saveUser(user);
        return true;
    }

    public boolean emailExist(String email) {
        return userService.findByEmail(email) != null;
    }

    public boolean isPasswordsAreDifferent(String password1, String password2) {
        return !password1.equals(password2);
    }

    public ModelAndView registerResponse(String firstName, String lastName, String email, String password1, String password2, Model model) {
        if (emailExist(email)) {
            model.addAttribute("message", "Email już istnieje.");
            model.addAttribute("messageType", "danger");
            return new ModelAndView("register");
        }

        if (isPasswordsAreDifferent(password1, password2)) {
            model.addAttribute("message", "Hasła są różne.");
            model.addAttribute("messageType", "danger");
            return new ModelAndView("register");
        }

        if (registerNewUser(firstName, lastName, email, password1, password2)) {
            model.addAttribute("message", "Konto zarejestrowane.");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Błąd");
            model.addAttribute("messageType", "danger");
        }
        return new ModelAndView("register");
    }
}
