package com.library.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.entity.Books;
import com.library.project.entity.Cart;
import com.library.project.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @PostMapping("/addbook")
    public Books saveToBooks(@RequestBody Books book) {
                  return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Books> searchBooksByName(@RequestParam("name") String bookName) {
        return bookRepository.findByBookNameContaining(bookName);
    }
    
    @GetMapping("/books/all")
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}

