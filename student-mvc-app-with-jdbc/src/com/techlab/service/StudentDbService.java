package com.techlab.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.techlab.model.Student;
import com.techlab.repository.StudentRepository;

public class StudentDbService implements IStudentService {
	StudentRepository repo=new StudentRepository();
	
	@Override
	public ArrayList<Student> getStudents() {
		ArrayList<Student> students;
		try {
			students = repo.getStudentFromDb();
			return students;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void addStudent(Student student) {
		try {
			repo.addStudentToDb(student);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }
	}
	
	@Override
	public void updateStudent(Student student)
	{
		try {
			repo.updateStudentToDb(student);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
