package com.pl.projekt;

import com.pl.projekt.dao.userDao;
import com.pl.projekt.entity.User;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjektApplication {
    
     @Autowired
     private userDao dao;
     
     @Autowired
     private PasswordEncoder passwordEncoder;
     
     public static void main(String[] args) {
        SpringApplication.run(ProjektApplication.class, args);
     }
 
}
