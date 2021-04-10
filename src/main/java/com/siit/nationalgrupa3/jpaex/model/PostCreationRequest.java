package com.siit.nationalgrupa3.jpaex.model;

import java.util.List;

import lombok.Data;

@Data
public class PostCreationRequest {

    private List<TagsInfo> tagsInfos;

    private String title;

}