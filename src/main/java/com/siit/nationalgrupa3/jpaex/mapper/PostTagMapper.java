package com.siit.nationalgrupa3.jpaex.mapper;

import com.siit.nationalgrupa3.jpaex.entity.PostTagEntity;
import com.siit.nationalgrupa3.jpaex.model.PostTagDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = TagMapper.class, componentModel = "spring")
public interface PostTagMapper {

    @Mapping(ignore = true, target = "post") // ignoram referinta circulara
    PostTagDto mapEntityToDto(PostTagEntity source);
}
