package net.guides.springboot2.springboot2jpacrudexample.Dao;

import net.guides.springboot2.springboot2jpacrudexample.entity.Student;

public interface Dao {
	Student getStudentDetailsById(long id);
}
