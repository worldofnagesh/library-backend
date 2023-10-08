package net.guides.springboot2.springboot2jpacrudexample.service;

import net.guides.springboot2.springboot2jpacrudexample.model.StudentDTO;

public interface Service {
	
	StudentDTO getStudentDetailsById(long id);
}
