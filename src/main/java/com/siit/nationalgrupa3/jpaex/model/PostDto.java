package com.siit.nationalgrupa3.jpaex.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // ca sa nu mai puna chei in json cu valori null
public class PostDto {

    private LocalDateTime createdAt;

    private Long id;

    private LocalDateTime modifiedAt;

    private List<PostTagDto> tags;

    private String title;

}