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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Patryk
 */
@Controller
public class UserBookController {
    
    @Autowired
    private userBookDao userBookDao;
    
    @Autowired
    private userDao userDao;
    
    @Autowired
    private bookDao bookDao;
    
    @RequestMapping(value = "/userBooks", method = RequestMethod.GET)
    public String userBooksPage(Model m, Principal principal) {
    User u = userDao.findByLogin(principal.getName());
    m.addAttribute("userbooklist", userBookDao.findByUserFK(u));
    return "userBooks";
    }
    
    @RequestMapping(value = "/toReadBooks", method = RequestMethod.GET)
    public String userToReadBooksPage(Model m, Principal principal) {
    User u = userDao.findByLogin(principal.getName());
    m.addAttribute("userbooklist", userBookDao.findByUserFK(u));
    return "toReadBooks";
    }
    
        @RequestMapping(value = "/readingBooks", method = RequestMethod.GET)
    public String userReadingBooksPage(Model m, Principal principal) {
    User u = userDao.findByLogin(principal.getName());
    m.addAttribute("userbooklist", userBookDao.findByUserFK(u));
    return "readingBooks";
    }
    
        @RequestMapping(value = "/readedBooks", method = RequestMethod.GET)
    public String userReadedBooksPage(Model m, Principal principal) {
    User u = userDao.findByLogin(principal.getName());
    m.addAttribute("userbooklist", userBookDao.findByUserFK(u));
    return "readedBooks";
    }
    
    @RequestMapping(value = "/addToLibrary", method = RequestMethod.GET)
    public String addBookToLibrary(Integer bookId, Principal principal){
        User u = userDao.findByLogin(principal.getName());
        Book b = bookDao.findByBookId(bookId);
        UserBook userBook = new UserBook(u,b,UserBook.bookStatus.TO_READ);
        userBookDao.save(userBook);
        return "redirect:/userBooks";
    }
    
    @RequestMapping(value = "/statusReading", method = RequestMethod.GET)
    public String changeStatusToReading(Integer userBookId, Integer bookId){
        UserBook userBook = userBookDao.findByUserBookId(userBookId);
        Book b = bookDao.findByBookId(bookId);
        userBook.setStatus(UserBook.bookStatus.READING);
        userBook.setBookFK(b);
        userBookDao.save(userBook);
        return "redirect:/readingBooks";
    }
    
    @RequestMapping(value = "/statusReaded", method = RequestMethod.GET)
    public String changeStatusToReaded(Integer userBookId, Integer bookId){
        UserBook userBook = userBookDao.findByUserBookId(userBookId);
        Book b = bookDao.findByBookId(bookId);
        userBook.setStatus(UserBook.bookStatus.READED);
        userBook.setBookFK(b);
        userBookDao.save(userBook);
        return "redirect:/readedBooks";
    }
    
    @RequestMapping(value = "/statusToRead", method = RequestMethod.GET)
    public String changeStatusToRead(Integer userBookId, Integer bookId){
        UserBook userBook = userBookDao.findByUserBookId(userBookId);
        Book b = bookDao.findByBookId(bookId);
        userBook.setStatus(UserBook.bookStatus.TO_READ);
        userBook.setBookFK(b);
        userBookDao.save(userBook);
        return "redirect:/toReadBooks";
    }
}
