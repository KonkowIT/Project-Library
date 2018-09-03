package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "RENT")
public class Rent {
    private int rentId;
    private int bookId;
    private int userId;
    private Book book;
    private User user;
    private LocalDate rentedDate;
    private LocalDate returnedDate;
    private LocalDate returnDeadline;

    public Rent(Book book, User user, LocalDate rentedDate) {
        this.book = book;
        this.user = user;
        this.rentedDate = rentedDate;
    }

    public Rent() { }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "RENT_ID")
    public int getRentId() {
        return rentId;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Book books;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public User users;

    @Column(name = "USER_ID")
    public int getUserId() {
        return user.getUserId();
    }

    @JoinColumn(name = "BOOK_ID")
    public int getBookId() {
        return book.getBookId();
    }

    @NotNull
    @Column(name = "RENTED_DATE")
    public LocalDate getRentedDate() {
        return rentedDate;
    }

    @Column(name = "RETURN_DEADLINE")
    public LocalDate getReturnDeadline(){
        return getRentedDate().plusDays(14);
    }

    @Column(name = "RETURNED_DATE")
    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRentedDate(LocalDate rentedDate) {
        this.rentedDate = rentedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void setReturnDeadline(LocalDate returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
