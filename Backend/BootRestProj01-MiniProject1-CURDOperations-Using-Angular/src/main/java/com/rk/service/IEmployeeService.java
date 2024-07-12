package com.rk.service;

import java.util.List;

import com.rk.entity.Employee;

public interface IEmployeeService {
	public String registerEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public String updateEmployeeInfo(Employee employee);
	public String deleteEmployeebyId(int id);
	public String updateEmployeeInfoByid(int id,Employee employee);
}
