package com.siit.nationalgrupa3.jpaex.repository;

import com.siit.nationalgrupa3.jpaex.entity.LibraryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {

    @Query()
    List<LibraryEntity> findAllById(int id);
}
