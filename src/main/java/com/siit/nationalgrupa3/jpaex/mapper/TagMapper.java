package com.siit.nationalgrupa3.jpaex.mapper;

import com.siit.nationalgrupa3.jpaex.entity.TagEntity;
import com.siit.nationalgrupa3.jpaex.model.TagDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "posts", ignore = true)// nu mapam posts ca sa evitam referinta circulara
    TagDto mapEntityToDto(TagEntity source);
}
