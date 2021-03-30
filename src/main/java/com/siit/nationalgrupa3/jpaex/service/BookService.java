package com.siit.nationalgrupa3.jpaex.service;

import com.siit.nationalgrupa3.jpaex.entity.BookEntity;
import com.siit.nationalgrupa3.jpaex.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookEntity createBook(BookEntity book) {

        return bookRepository.save(book);
    }

    public List<BookEntity> getBookss() {
        return bookRepository.findAll();
    }

    public BookEntity getBook(Integer bookId) {

        return bookRepository.findById(bookId).get();
    }

    public void deleteBook(Integer bookId) {

        bookRepository.deleteById(bookId);
    }
}
