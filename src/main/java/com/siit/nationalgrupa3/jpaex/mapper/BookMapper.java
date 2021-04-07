package com.siit.nationalgrupa3.jpaex.mapper;

import com.siit.nationalgrupa3.jpaex.entity.BookEntity;
import com.siit.nationalgrupa3.jpaex.model.BookDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {


    @Mapping(target = "library", ignore = true)
//    @Mapping(source = "numeInDto", target = "numeInEntity")
    BookEntity mapDtoToEntity(BookDto source);

    @Mapping(target = "library", ignore = true)
    BookDto mapEntityToDto(BookEntity source);

    List<BookDto> mapListEntityToListDto(List<BookEntity> source);

}
