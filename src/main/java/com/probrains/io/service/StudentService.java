package com.probrains.io.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.probrains.io.dao.StudentDAO;
import com.probrains.io.entity.Student;

@Service
public class StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}
	
	@Transactional
	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Transactional
	public void saveStudents(Student theStudent) {
		studentDAO.saveStudents(theStudent);
	}

	@Transactional
	public void delete(int userId) {
		studentDAO.delete(userId);
	}
	
}
