/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.dao;

import com.pl.projekt.entity.User;
import com.pl.projekt.entity.UserBook;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Patryk
 */
public interface userBookDao extends CrudRepository<UserBook, Integer> {
    
    @Override
    public UserBook save(UserBook userBook);
    
    public UserBook findByUserBookId(Integer userBookId);
    
    public List<UserBook> findByUserFK(User user);
}
