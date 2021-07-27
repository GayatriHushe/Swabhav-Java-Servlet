package com.techlab.model;

public class Admin {

	private String adminName,adminPassword;

	public Admin(String adminName, String adminPassword) {
		this.adminName=adminName;
		this.adminPassword=adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}

}
