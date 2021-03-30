package com.siit.nationalgrupa3.jpaex.controller;

import com.siit.nationalgrupa3.jpaex.entity.BookEntity;
import com.siit.nationalgrupa3.jpaex.service.BookService;

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
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookEntity create(@Valid @RequestBody BookEntity book) {

        return bookService.createBook(book);
    }

    @GetMapping("/{bookId}")
    public BookEntity getBook(@PathVariable(name = "bookId") Integer bookId) {

        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable(name = "bookId") Integer bookId) {

        bookService.deleteBook(bookId);
    }
    @GetMapping()
    public List<BookEntity> getBooks() {

        return bookService.getBookss();
    }
}
