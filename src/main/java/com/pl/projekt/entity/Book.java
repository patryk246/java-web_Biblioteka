/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.projekt.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Patryk
 */
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    @NotBlank
    @Size(min = 1, max = 50, message = "Tytuł musi mieć od 1 do 50 znaków")
    private String title;
    @NotBlank
    @Size(min = 1, max = 50, message = "Imię musi mieć od 1 do 50 znaków")
    private String authorName;
    @NotBlank
    @Size(min = 1, max = 50, message = "Nazwisko musi mieć od 1 do 50 znaków")
    private String authorSurname;
    @NotBlank
    private String type;
    @OneToMany(mappedBy = "userFK", cascade = CascadeType.ALL)
    private Set<UserBook> bookUsers;
    
    public Book() {
    }
    
    public Book(String title, String authorName, String authorSurname, String type) {
    this.title = title;
    this.authorName = authorName;
    this.authorSurname = authorSurname;
    this.type = type;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserBook> getBookUsers() {
        return bookUsers;
    }

    public void addBookUser(UserBook userBook){
        bookUsers.add(userBook);
    }
    
    
}
