package com.techlab.service;

import java.util.ArrayList;
import java.util.List;

import com.techlab.model.Student;

public class StudentService {
	ArrayList<Student> students=new ArrayList<Student>();
	
	public StudentService() {
		students.add(new Student(1, "Gayatri", 9.52, "Mumbai"));
		students.add(new Student(2, "Deepak", 9.52, "Navi-Mumbai"));
		students.add(new Student(3, "Shivam", 9.52, "Mumbai"));
		students.add(new Student(4, "Nikhil", 9.52, "Navi-Mumbai"));
		students.add(new Student(5, "Raj", 9.52, "Mumbai"));	
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
}