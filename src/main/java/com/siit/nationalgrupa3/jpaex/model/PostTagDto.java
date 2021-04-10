package com.siit.nationalgrupa3.jpaex.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostTagDto {

    private long id;

    private PostDto post;

    private int quantity;

    private TagDto tag;
}
