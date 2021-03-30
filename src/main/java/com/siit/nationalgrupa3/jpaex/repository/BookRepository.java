package com.siit.nationalgrupa3.jpaex.repository;

import com.siit.nationalgrupa3.jpaex.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
