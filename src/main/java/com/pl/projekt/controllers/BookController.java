/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.controllers;

import com.pl.projekt.dao.bookDao;
import com.pl.projekt.dao.userBookDao;
import com.pl.projekt.dao.userDao;
import com.pl.projekt.entity.Book;
import com.pl.projekt.entity.User;
import com.pl.projekt.entity.UserBook;
import java.security.Principal;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Patryk
 */
@Controller
public class BookController {
    
    @Autowired
    private bookDao bookDao;
    
    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public String allBooksPage(Model m) {
    m.addAttribute("booklist", bookDao.findAll());
    return "allBooks";
    }
    
        @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public String newBookPage(Model m) {
    m.addAttribute("book", new Book());
    return "newBook";
    }
    
    @RequestMapping(value = "/newBook", method = RequestMethod.POST)
    public String newBookPagePOST(@ModelAttribute(value = "book") @Valid Book book, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "newBook";
    }
    bookDao.save(book);
    return "redirect:/allBooks";
    }
    

}
