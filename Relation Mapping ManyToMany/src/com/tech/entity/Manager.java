package com.tech.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Manager {
	
	@Id
	private int M_Id;
	
	private String M_Name;
	
	private String M_Department;
	
	public int getM_Id() {
		return M_Id;
	}

	public void setM_Id(int m_Id) {
		M_Id = m_Id;
	}

	public String getM_Name() {
		return M_Name;
	}

	public void setM_Name(String m_Name) {
		M_Name = m_Name;
	}

	public String getM_Department() {
		return M_Department;
	}

	public void setM_Department(String m_Department) {
		M_Department = m_Department;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@ManyToMany
	private List<Employee> employee;

}
