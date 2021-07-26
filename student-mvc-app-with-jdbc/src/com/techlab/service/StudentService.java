package com.techlab.service;

import java.util.ArrayList;
import java.util.List;

import com.techlab.model.Student;

public class StudentService implements IStudentService {
	ArrayList<Student> students=new ArrayList<Student>();
	
	public StudentService() {
		students.add(new Student(1, "Gayatri", 9.52, "Mumbai"));
		students.add(new Student(2, "Deepak", 9.52, "Navi-Mumbai"));
		students.add(new Student(3, "Shivam", 9.52, "Mumbai"));
		students.add(new Student(4, "Nikhil", 9.52, "Navi-Mumbai"));
		students.add(new Student(5, "Raj", 9.52, "Mumbai"));	
	}
	
	@Override
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	@Override
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public void updateStudent(Student student)
	{
		
	}

	@Override
	public String toString() {
		return "StudentService [students=" + students + "]";
	}
	
}
