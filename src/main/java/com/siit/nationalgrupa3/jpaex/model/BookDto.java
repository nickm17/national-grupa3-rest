package com.siit.nationalgrupa3.jpaex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BookDto {

    private int id;

    @JsonIgnore
    private LibraryDto library;

    private String name;

}
