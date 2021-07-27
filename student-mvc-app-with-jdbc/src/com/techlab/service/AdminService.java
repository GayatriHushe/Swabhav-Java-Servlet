package com.techlab.service;

import java.util.ArrayList;
import com.techlab.model.Admin;

public class AdminService {
	ArrayList<Admin> admins=new ArrayList<Admin>();

	public AdminService() {
		admins.add(new Admin("Gayatri", "g@123"));
		admins.add(new Admin("Deepak", "d@123"));
		admins.add(new Admin("Shivam", "s@123"));
		admins.add(new Admin("Nikhil", "n@123"));
		admins.add(new Admin("Raj", "r@123"));
		admins.add(new Admin("Gaurav", "gv@123"));
		
	}

	public ArrayList<Admin> getAdmins() {
		return admins;
	}

	public void addAdmin(Admin admin)
	{
		admins.add(admin);
	}
	
	public boolean isAdmin(Admin admin)
	{
		
		for (Admin a : admins) {
			if(a.getAdminName().equals(admin.getAdminName()) && a.getAdminPassword().equals(admin.getAdminPassword()))
				return true;
		}
		return false;
		
	}

}
