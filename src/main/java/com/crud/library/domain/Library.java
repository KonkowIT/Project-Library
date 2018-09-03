package com.crud.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LIBRARY")
public class Library {
    private String title;
    private String author;
    private int quantity;
    private int rentedQuantity;
    private int inStockQuantity;

    public Library(@NotNull String title, String author, int quantity, int rentedQuantity, int inStockQuantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.rentedQuantity = rentedQuantity;
        this.inStockQuantity = inStockQuantity;
    }

    public Library() { }

    @Id
    @NotNull
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "RENTED_QUANTITY")
    public int getRentedQuantity() {
        return rentedQuantity;
    }

    @Column(name = "IN_STOCK_QUANTITY")
    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRentedQuantity(int rentedQuantity) {
        this.rentedQuantity = rentedQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }
}
