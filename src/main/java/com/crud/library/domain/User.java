package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "USERS")
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private BigInteger pesel;

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull BigInteger pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public User() { }

    @ManyToOne(fetch = FetchType.LAZY)
    private Rent rent;

    @Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue
    public int getUserId() {
        return userId;
    }

    @NotNull
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }


    @Column(name = "PESEL")
    public BigInteger getPesel() {
        return pesel;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(BigInteger pesel) {
        this.pesel = pesel;
    }
}