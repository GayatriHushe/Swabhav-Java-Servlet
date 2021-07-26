package com.techlab.model;

import java.util.UUID;

public class Student {
	private int rollNo;
	private String name,location;
	private double cgpa;
	private String id;
	
	public Student(int rollNo, String name, double cgpa, String location) {
		UUID uuid = UUID.randomUUID();
		this.id=uuid.toString();
		this.rollNo=rollNo;
		this.name=name;
		this.cgpa=cgpa;
		this.location=location;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public double getCgpa() {
		return cgpa;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", location=" + location + ", cgpa=" + cgpa + ", id="
				+ id + "]";
	}
	
}
