package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryDto {
    @NotNull
    private String title;
    private String author;
    private int quantity;
    private int rentedQuantity;
    private int inStockQuantity;

}
