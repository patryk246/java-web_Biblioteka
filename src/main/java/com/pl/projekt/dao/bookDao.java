/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.dao;

import com.pl.projekt.entity.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Patryk
 */
public interface bookDao extends CrudRepository<Book, Integer>{
    @Override
    public List<Book> findAll();
    
    @Override
    public Book save(Book book);
    
    public Book findByBookId(Integer bookId);
}
