package com.library.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findById(long id);
	Student findByDob(String dob);
 
}
