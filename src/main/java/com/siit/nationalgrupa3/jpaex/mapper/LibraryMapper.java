package com.siit.nationalgrupa3.jpaex.mapper;

import com.siit.nationalgrupa3.jpaex.entity.LibraryEntity;
import com.siit.nationalgrupa3.jpaex.model.LibraryDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = BookMapper.class, componentModel = "spring")
public interface LibraryMapper {

    LibraryEntity mapDtoToEntity(LibraryDto source);
    LibraryDto mapEntityToDto(LibraryEntity source);

    List<LibraryDto> mapListEntityToListDto(List<LibraryEntity> source);

}
