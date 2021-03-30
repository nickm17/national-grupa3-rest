package com.siit.nationalgrupa3.jpaex.controller;

import com.siit.nationalgrupa3.jpaex.entity.LibraryEntity;
import com.siit.nationalgrupa3.jpaex.service.LibraryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public LibraryEntity create(@Valid @RequestBody LibraryEntity library) {

        return libraryService.createLibrary(library);
    }

    @GetMapping("/{libraryId}")
    public LibraryEntity getLibrary(@PathVariable(name = "libraryId") Integer libraryId) {

        return libraryService.getLibrary(libraryId);
    }

    @DeleteMapping("/{libraryId}")
    public void deleteLibrary(@PathVariable(name = "libraryId") Integer libraryId) {

        libraryService.deleteLibrary(libraryId);
    }

    @GetMapping()
    public List<LibraryEntity> getLibraries() {

        return libraryService.getLibraries();
    }
}
