package com.tech.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int E_Id;
	
	private String E_name;
	
	private double E_Salary;
	
	@ManyToMany
	private List<Manager> manager;

	public int getE_Id() {
		return E_Id;
	}

	public void setE_Id(int e_Id) {
		E_Id = e_Id;
	}

	public String getE_name() {
		return E_name;
	}

	public void setE_name(String e_name) {
		E_name = e_name;
	}

	public double getE_Salary() {
		return E_Salary;
	}

	public void setE_Salary(double e_Salary) {
		E_Salary = e_Salary;
	}

	public List<Manager> getManager() {
		return manager;
	}

	public void setManager(List<Manager> manager) {
		this.manager = manager;
	}

}
