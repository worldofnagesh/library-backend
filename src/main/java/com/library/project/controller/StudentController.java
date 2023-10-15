package com.library.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.entity.Student;
import com.library.project.exception.ResourceNotFoundException;
import com.library.project.model.StudentDTO;
import com.library.project.repository.StudentRepository;
import com.library.project.service.Service;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	Service service;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() ->new ResourceNotFoundException("Student not found for this id :: " + studentId));
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/students/login")
	public ResponseEntity<String> getStudentDetailsbyid(@RequestBody StudentDTO loginDto) {
		StudentDTO loginDetail= service.getStudentDetailsById(loginDto.getId());

		ResponseEntity<String> response = null;

		if ((0 != loginDetail.getId()) && (loginDetail.getId()==(loginDto.getId()))
				&& (loginDetail.getPassword()).equalsIgnoreCase(loginDto.getPassword())) {

			response = ResponseEntity.status(HttpStatus.CREATED).body("Validated credential successfully");
		} else {
			response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials...");
		}
		return response;

	}
	@PutMapping("/students/{id}")
	public void updateStudent(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
  				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
		Optional<String> optional = compareStrings(studentDetails.getDob(), student.getDob());
		
        try {
            optional.orElseThrow(() -> new ResourceNotFoundException("Strings are not equal"));
            student.setPassword(studentDetails.getPassword());
 		    final Student updatedStudent = studentRepository.save(student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
	}	
//	@PutMapping("/students/{id}")
//	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
//			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
//		Student student = studentRepository.findById(studentId)
//				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
//
//		student.setDob(studentDetails.getDob());
//		student.setPassword(studentDetails.getPassword());
//		final Student updatedStudent = studentRepository.save(student);
//		return ResponseEntity.ok(updatedStudent);
//	}
	
	@PutMapping("/studentinfo/{id}")
	public ResponseEntity<Student> updateStudentInfo(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		student.setEmailId(studentDetails.getEmailId());
		final Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + studentId));

		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public static Optional<String> compareStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return Optional.of(str1);
            
        } else {
            return Optional.empty();
            
        }
    }
}

