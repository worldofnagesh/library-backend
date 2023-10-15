package com.library.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    List<Books> findByBookNameContaining(String bookName);
}
