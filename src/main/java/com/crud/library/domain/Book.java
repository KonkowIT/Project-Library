package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOKS")
public class Book {
    private int bookId;
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(@NotNull String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Book(){}

    @OneToOne(mappedBy = "books")
    private Rent rent;

    @Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue
    public int getBookId() {
        return bookId;
    }

    @NotNull
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name = "YEAR_OF_PUBLICATION")
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }


}