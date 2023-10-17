package com.library.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.library.project.entity.DueBooks;

   @Repository
	public interface DueBooksRepository extends JpaRepository< DueBooks, Long> {
	    
	   List<DueBooks> findByid(Long id);
	}
