package com.siit.nationalgrupa3.jpaex.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LibraryDto {
    private int id;

    @NotBlank
    private String name;

    private Set<BookDto> books = new HashSet<>();
}
