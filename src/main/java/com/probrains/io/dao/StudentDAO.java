package com.probrains.io.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.probrains.io.entity.Student;

@Repository
public class StudentDAO {

	@Autowired
	private DBServiceUtil theDBServiceUtil;

	public List<Student> getStudents() {
		return theDBServiceUtil.getAll(Student.class);
	}

	public void saveStudents(Student theStudent) {
		theDBServiceUtil.save(theStudent);
	}
	
	public Student getStudent(int studentId) {
		return theDBServiceUtil.getById(Student.class, studentId);
	}

	public void delete(int studentId) {
		theDBServiceUtil.delete(Student.class, studentId);
	}
}
