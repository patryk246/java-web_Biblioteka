/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "UsersBooks")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userBookId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User userFK;
    @ManyToOne
    @JoinColumn(name="bookId")
    private Book bookFK;
    @Enumerated(EnumType.STRING)
    private bookStatus status;
    public enum bookStatus{
        TO_READ,
        READING,
        READED
    };
    
    public UserBook(){
        
    }
    
    public UserBook(User userId, Book bookId, bookStatus status){
        this.userFK=userId;
        this.bookFK=bookId;
        this.status=status;
    }

    public Integer getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(Integer userBookId) {
        this.userBookId = userBookId;
    }

    public User getUserFK() {
        return userFK;
    }

    public void setUserFK(User userFK) {
        this.userFK = userFK;
    }

    public Book getBookFK() {
        return bookFK;
    }

    public void setBookFK(Book bookFK) {
        this.bookFK = bookFK;
    }

    public bookStatus getStatus() {
        return status;
    }

    public void setStatus(bookStatus status) {
        this.status = status;
    }
    
    
}
