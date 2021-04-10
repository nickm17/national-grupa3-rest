package com.siit.nationalgrupa3.jpaex.mapper;

import com.siit.nationalgrupa3.jpaex.entity.PostEntity;
import com.siit.nationalgrupa3.jpaex.model.PostDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = PostTagMapper.class, componentModel = "spring")
public interface PostMapper {

    PostDto mapEntityToDto(PostEntity source);

    List<PostDto> mapListEntityToListDto(List<PostEntity> source);

}
