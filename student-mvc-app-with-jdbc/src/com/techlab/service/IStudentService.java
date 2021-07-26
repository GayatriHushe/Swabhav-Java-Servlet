package com.techlab.service;

import java.util.ArrayList;
import com.techlab.model.Student;

public interface IStudentService {

	public ArrayList<Student> getStudents();

	public void addStudent(Student student);
	
	public void updateStudent(Student student);

}