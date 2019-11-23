/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.dao;

import com.pl.projekt.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Patryk
 */
public interface userDao extends CrudRepository<User, Integer> {
    
 public User findByLogin(String login);
 @Override
 public List< User> findAll();
 @Override
 public void delete(User u);
}
