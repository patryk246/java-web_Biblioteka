/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.controllers;

import com.pl.projekt.dao.userDao;
import com.pl.projekt.entity.User;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Patryk
 */
@Controller
public class UserController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private userDao dao;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
    //zwrócenie nazwy widoku logowania - login.html
    return "login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model m) {
    //dodanie do modelu nowego użytkownika
    m.addAttribute("user", new User());
    //zwrócenie nazwy widoku rejestracji - register.html
    return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPagePOST(@ModelAttribute(value = "user") User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    dao.save(user);
    //przekierowanie do adresu url: /login
    return "redirect:/login";
    }
}
