package com.library.project.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.project.Dao.Dao;
import com.library.project.entity.Student;
import com.library.project.repository.StudentRepository;

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
