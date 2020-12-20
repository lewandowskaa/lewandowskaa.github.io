package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    //servis z logika dla uzytkownika

    @Autowired
    private UserRepository userRepository;

    public User findById(Integer userId) {
        return userRepository.findById(userId).isPresent() ? userRepository.findById(userId).get() : null;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).isPresent() ? userRepository.findByEmail(email).get() : null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User loggedUser(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        return findByEmail(email);
    }
}
