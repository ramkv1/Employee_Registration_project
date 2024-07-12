package com.rk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Employee;

public interface EmployeeInfoRepository extends JpaRepository<Employee, Integer>{

}
