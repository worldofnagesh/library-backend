package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import jakarta.validation.Valid;
import net.guides.springboot2.springboot2jpacrudexample.entity.Student;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.StudentDTO;
import net.guides.springboot2.springboot2jpacrudexample.repository.StudentRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.Service;

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
				.orElseThrow(() -> new ResourceNotFoundException("StudentDTO not found for this id :: " + studentId));
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
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("StudentDTO not found for this id :: " + studentId));

//		student.setEmailId(studentDetails.getEmailId());
//		student.setFullName(studentDetails.getFullName());
		student.setDob(studentDetails.getDob());
//		student.setGender(studentDetails.getGender());
		student.setPassword(studentDetails.getPassword());
		final Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@PutMapping("/studentinfo/{id}")
	public ResponseEntity<Student> updateStudentInfo(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("StudentDTO not found for this id :: " + studentId));

		student.setEmailId(studentDetails.getEmailId());
//		student.setFullName(studentDetails.getFullName());
//		student.setDob(studentDetails.getDob());
//		student.setGender(studentDetails.getGender());
//		student.setPassword(studentDetails.getPassword());
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
}

