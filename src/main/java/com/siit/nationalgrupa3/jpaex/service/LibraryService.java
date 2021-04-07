package com.siit.nationalgrupa3.jpaex.service;

import com.siit.nationalgrupa3.ApplicationProperties;
import com.siit.nationalgrupa3.jpaex.entity.LibraryEntity;
import com.siit.nationalgrupa3.jpaex.mapper.LibraryMapper;
import com.siit.nationalgrupa3.jpaex.model.LibraryDto;
import com.siit.nationalgrupa3.jpaex.repository.LibraryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final ApplicationProperties applicationProperties;

//    @Value("${national.grupa3.rest.library}")
//    private String newName;

    public LibraryDto createLibrary(LibraryDto libraryDto) {
        var libraryEntity = libraryMapper.mapDtoToEntity(libraryDto);

        return libraryMapper.mapEntityToDto(libraryRepository.save(libraryEntity));
    }

    public List<LibraryDto> getLibraries() {
        List<LibraryEntity> all = libraryRepository.findAll();
        System.out.println(all.toString());
        return libraryMapper.mapListEntityToListDto(all);
    }

    public LibraryDto getLibrary(Integer libraryId) {

        return libraryMapper.mapEntityToDto(libraryRepository.findById(libraryId).get());
    }

    public void deleteLibrary(Integer libraryId) {

        libraryRepository.deleteById(libraryId);
    }

    @Transactional
    public void deleteBookFromLibrary(Integer libraryId, Integer bookIdToRemove) {

        LibraryEntity libraryEntity = libraryRepository.findById(libraryId).get();
        libraryEntity.getBooks()
                         .removeIf(bookEntity -> bookIdToRemove == bookEntity.getId());

        libraryEntity.getBooks().stream()
                     .forEach(book -> book.setName(applicationProperties.getBookName()));

        libraryEntity.setName(applicationProperties.getLibrary());
    }
}
