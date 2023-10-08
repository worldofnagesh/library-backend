package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findById(long id);
 
}
