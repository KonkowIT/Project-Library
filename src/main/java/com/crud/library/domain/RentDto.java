package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentDto {
    @NotNull
    private int bookId;
    private int userId;
    private static LocalDate rentedDate;
    private static LocalDate returnedDate;
    private boolean isRented;
}
