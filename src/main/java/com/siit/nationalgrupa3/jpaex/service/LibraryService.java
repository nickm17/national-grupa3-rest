package com.siit.nationalgrupa3.jpaex.service;

import com.siit.nationalgrupa3.jpaex.entity.LibraryEntity;
import com.siit.nationalgrupa3.jpaex.repository.LibraryRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryEntity createLibrary(LibraryEntity library) {

        return libraryRepository.save(library);
    }

    public List<LibraryEntity> getLibraries() {
        List<LibraryEntity> all = libraryRepository.findAll();
        System.out.println(all.toString());
        return all;
    }

    public LibraryEntity getLibrary(Integer libraryId) {

        return libraryRepository.findById(libraryId).get();
    }

    public void deleteLibrary(Integer libraryId) {

        libraryRepository.deleteById(libraryId);
    }
}
