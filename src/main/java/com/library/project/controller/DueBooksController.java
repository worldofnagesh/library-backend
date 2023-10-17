package com.library.project.controller;



import java.util.List;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.library.project.entity.Cart;
import com.library.project.entity.DueBooks;

import com.library.project.repository.DueBooksRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController

@RequestMapping("/api/v1")

public class DueBooksController {

	

    @Autowired
    private DueBooksRepository dueBooksRepository;



    @PostMapping("/duebooks")
    public DueBooks createDueBook(@RequestBody DueBooks dueBooks) {

        return dueBooksRepository.save(dueBooks);

    }



    @GetMapping("/duebooks/{id}")
    public List<DueBooks> getCartItemsByStudentId(@PathVariable("id") Long id) {
        return dueBooksRepository.findByid(id);
    }

}
