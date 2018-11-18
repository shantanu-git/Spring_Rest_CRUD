package com.probrains.io.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probrains.io.entity.Student;
import com.probrains.io.entity.UserResponse;
import com.probrains.io.service.StudentService;

@RestController
@RequestMapping("/studentapi")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getListOfSudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public UserResponse<Student> getUserById(@PathVariable int studentId) {
		Student theStudent = studentService.getStudent(studentId);
		UserResponse<Student> theUserResponse = null;
		if (theStudent == null) {
			String message = "Student id not found: " + studentId;
			theUserResponse = new UserResponse<Student>(HttpStatus.NOT_FOUND.value(), true, System.currentTimeMillis(), message,
					null);
		} else {
			theUserResponse = new UserResponse<Student>(HttpStatus.OK.value(), false, System.currentTimeMillis(), "Success",
					theStudent);
		}
		return theUserResponse;
	}

	@PostMapping("/students")
	public Student addUser(@RequestBody Student theStudent) {
		studentService.saveStudents(theStudent);
		return theStudent;
	}

	@PutMapping("/students")
	public Student updateUser(@RequestBody Student theStudent) {
		studentService.saveStudents(theStudent);
		return theStudent;
	}

	@DeleteMapping("/students/{studentId}")
	public UserResponse<Student> deleteUser(@PathVariable int studentId) {
		Student theStudent = studentService.getStudent(studentId);
		UserResponse<Student> theUserResponse = null;
		if (theStudent == null) {
			String message = "Student id not found: " + studentId;
			theUserResponse = new UserResponse<Student>(HttpStatus.NOT_FOUND.value(), true, System.currentTimeMillis(), message,
					null);
		} else {
			studentService.delete(studentId);
			String message = "Delete user id is : " + studentId;
			theUserResponse = new UserResponse<Student>(HttpStatus.OK.value(), false, System.currentTimeMillis(), message, null);
		}

		return theUserResponse;
	}
}
