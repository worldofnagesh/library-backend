package com.library.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.project.Dao.Dao;
import com.library.project.entity.Student;
import com.library.project.model.StudentDTO;
import com.library.project.service.Service;

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
