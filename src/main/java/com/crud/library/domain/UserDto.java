package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private int pesel;

    public UserDto(String userFirstName, String userLastName, int pesel) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.pesel = pesel;
    }
}
