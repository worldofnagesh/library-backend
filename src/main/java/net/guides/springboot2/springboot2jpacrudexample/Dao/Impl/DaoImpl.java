package net.guides.springboot2.springboot2jpacrudexample.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.Dao.Dao;
import net.guides.springboot2.springboot2jpacrudexample.entity.Student;
import net.guides.springboot2.springboot2jpacrudexample.repository.StudentRepository;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	StudentRepository studentrepository;
	
	@Override
	public Student getStudentDetailsById(long id) {
		Student UserDetails = studentrepository.findById(id);
		return UserDetails;
	}
}
