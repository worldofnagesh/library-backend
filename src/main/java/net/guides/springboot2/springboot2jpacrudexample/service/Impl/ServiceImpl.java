package net.guides.springboot2.springboot2jpacrudexample.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import net.guides.springboot2.springboot2jpacrudexample.Dao.Dao;
import net.guides.springboot2.springboot2jpacrudexample.entity.Student;
import net.guides.springboot2.springboot2jpacrudexample.model.StudentDTO;
import net.guides.springboot2.springboot2jpacrudexample.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	Dao dao;
	
	@Override
	public StudentDTO getStudentDetailsById(long id) {
		Student loginDetail = dao.getStudentDetailsById(id);
		
		StudentDTO loginDto = new StudentDTO();
	 if(null!=loginDetail) {
		 loginDto.setId(loginDetail.getId());
		 loginDto.setPassword(loginDetail.getPassword());
	 }
	
		return loginDto;
	}
}
