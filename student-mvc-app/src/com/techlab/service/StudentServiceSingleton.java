package com.techlab.service;

public class StudentServiceSingleton
{
	private static StudentService studentService = null;
	
	public static StudentService getService()
	{
		if(studentService == null)
		{
			studentService = new StudentService();
			return studentService;
		}
		return studentService;
	}
}
