package com.techlab.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import com.mysql.jdbc.Statement;
import com.techlab.model.Student;

public class StudentRepository {

	public void addStudentToDb(Student student) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");	

		PreparedStatement ps=(PreparedStatement) con.prepareStatement("INSERT INTO STUDENT_INFO (ID,ROLL_NO,NAME,CGPA,LOCATION) VALUES(?,?,?,?,?)");
		ps.setString(1, UUID.randomUUID().toString());
	    ps.setInt(2, student.getRollNo());
	    ps.setString(3, student.getName());
	    ps.setDouble(4,student.getCgpa());
	    ps.setString(5, student.getLocation());
	    
	    int result=ps.executeUpdate();
	    if(result>0) {
	      System.out.println("Student added");
	    }
	}

	public  ArrayList<Student> getStudentFromDb() throws ClassNotFoundException, SQLException
	{
		ArrayList<Student> students=new ArrayList<Student>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");	

		Statement stmt = (Statement) con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENT_INFO ;");
		while(rs.next())
		{
			System.out.println("Students : ");
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getString(5));
			Student student=new Student(rs.getInt("ROLL_NO"),rs.getString("NAME"),rs.getDouble("CGPA"),rs.getString("LOCATION"));
			student.setId(rs.getString("ID"));
			students.add(student);
		}
			
		rs.close();
		return students;
	}
	
	
	public void updateStudentToDb(Student student) throws ClassNotFoundException, SQLException
	{
		System.out.println("repo : " + student);
		int rowUpdated;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");	

		PreparedStatement ps=(PreparedStatement) con.prepareStatement("UPDATE STUDENT_INFO SET ROLL_NO=? ,NAME=?, CGPA=?, LOCATION=? WHERE ID=?");
		
	    ps.setInt(1, student.getRollNo());
	    ps.setString(2, student.getName());
	    ps.setDouble(3,student.getCgpa());
	    ps.setString(4, student.getLocation());
	    ps.setString(5, student.getId());
	    rowUpdated=ps.executeUpdate();
	    if(rowUpdated>0) {
	      System.out.println("Row Updated"); 
	    }
	    con.close();
	    
	}
	
	public Student selectStudent(String id) throws ClassNotFoundException, SQLException {
		Student student=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");	

		PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT_INFO WHERE ID=? ;");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int rollNo=rs.getInt("ROLL_NO");
			String name = rs.getString("NAME");
			double cgpa = rs.getDouble("CGPA");
			String location = rs.getString("LOCATION");
			student = new Student(rollNo, name, cgpa, location);
			student.setId(rs.getString(id));
		}
			
		rs.close();
		
		return student;
	}
	
	public void deleteStudentFromDb(String id) throws ClassNotFoundException, SQLException
	{
		int rowDeleted;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");	

		PreparedStatement ps=(PreparedStatement) con.prepareStatement("DELETE FROM STUDENT_INFO WHERE ID=?");
		
		ps.setString(1, id);
		
		rowDeleted=ps.executeUpdate();
		if(rowDeleted>0)
			System.out.println("Row deleted");
		else
			System.out.println("Row not deleted");
		con.close();
	}
	
}
