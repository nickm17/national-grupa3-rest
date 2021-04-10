package com.siit.nationalgrupa3.jpaex.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto {

    private LocalDateTime createdAt;

    private Long id;

    private LocalDateTime modifiedAt;

    private String name;

    private List<PostTagDto> posts;

}
