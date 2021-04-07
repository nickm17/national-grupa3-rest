package com.siit.nationalgrupa3.jpaex.controller;

import com.siit.nationalgrupa3.jpaex.model.LibraryDto;
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
import javax.validation.constraints.NotNull;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public LibraryDto create(@Valid @RequestBody @NotNull LibraryDto library) {

        return libraryService.createLibrary(library);
    }

    @GetMapping("/{libraryId}")
    public LibraryDto getLibrary(@PathVariable(name = "libraryId") Integer libraryId) {

        return libraryService.getLibrary(libraryId);
    }

    @DeleteMapping("/{libraryId}")
    public void deleteLibrary(@PathVariable(name = "libraryId") Integer libraryId) {

        libraryService.deleteLibrary(libraryId);
    }

    @DeleteMapping("/{libraryId}/books/{bookId}")
    public void deleteBookFromLibrary(@PathVariable(name = "libraryId") Integer libraryId,
                                      @PathVariable(name = "bookId") Integer bookId) {

        libraryService.deleteBookFromLibrary(libraryId, bookId);
    }

    @GetMapping()
    public List<LibraryDto> getLibraries() {

        return libraryService.getLibraries();
    }
}
