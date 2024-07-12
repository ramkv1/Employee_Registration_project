package com.rk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Employee;
import com.rk.repo.EmployeeInfoRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeInfoRepository repo; 
	
	
	@Override
	public String registerEmployee(Employee employee) {
		Employee emp=repo.save(employee);
		return "Employee obj is saved with id value::"+emp.getId();
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=repo.findAll();
		list.sort((d1,d2)->d1.getFirstName().compareTo(d2.getFirstName()));
		return list;
	}

	@Override
	public String updateEmployeeInfo(Employee employee) {
		//Find Employee
		Optional<Employee> opt=repo.findById(employee.getId());
		if(opt.isPresent()) {
			//update Employee
			repo.save(employee);
			return employee.getId()+"Employee Details are updated";
		}
		else {
			return employee.getId()+"Employee is Not Found";
		}
	}

	@Override
	public String deleteEmployeebyId(int id) {
		//get find the object
				Optional<Employee> opt=repo.findById(id);
				if(opt.isPresent()) {
					repo.deleteById(id);
					return id+"::id doctor is deleted";
				}
				else {
					return id+"Employee is Not Found";
				}
	}

	@Override
	public String updateEmployeeInfoByid(int id,Employee employee) {
		//get find the object
		Optional<Employee> opt=repo.findById(employee.getId());
		if(opt.isPresent()) {
			repo.save(employee);
			return "Employee Updated Successfully";
		}
		else {
			return id+"Employee is Not Found";
		}
	}

}
