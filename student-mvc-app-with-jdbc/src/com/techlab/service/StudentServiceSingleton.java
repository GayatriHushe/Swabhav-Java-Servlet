package com.techlab.service;

public class StudentServiceSingleton
{
	private static IStudentService studentService = null;
	
	public static IStudentService getService()
	{
		if(studentService == null)
		{
			studentService = new StudentService();
			return studentService;
		}
		return studentService;
	}
}
