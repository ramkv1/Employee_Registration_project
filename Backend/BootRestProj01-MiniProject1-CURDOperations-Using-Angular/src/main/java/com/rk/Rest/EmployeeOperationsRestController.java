package com.rk.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.Employee;
import com.rk.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsRestController {
	
	@Autowired
	private IEmployeeService service;
	

	//==============Save operation===========

	@PostMapping("/save")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
		//use service
		String resultMsg=service.registerEmployee(employee);
		//return ResponseEntity Object
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}

	//==============Fetch operation===========
	
	@GetMapping("/report")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> showAllEmployee(){

		List<Employee> list=service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);

	}
	
	//==============Update operation===========
	
	@PutMapping("/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> modifyEmployeeInfo(@RequestBody Employee employee) throws Exception{
		//use service
		String resultMsg=service.updateEmployeeInfo(employee);
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
	}
	
	//==============delete operation===========
			@DeleteMapping("/delete/{id}")
			@CrossOrigin(origins = "http://localhost:4200")
			public ResponseEntity<String> removeEmployeeById(@PathVariable Integer id) throws Exception{
				
					//use service
					String resultMsg=service.deleteEmployeebyId(id);
					return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
					
			
			}

			@PutMapping("/update1/{id}")
			@CrossOrigin(origins = "http://localhost:4200")
			public ResponseEntity<?> modifyEmployeeInfoById(@PathVariable Integer id,@RequestBody Employee employee) throws Exception{
				//use service
				String resultMsg=service.updateEmployeeInfoByid(id,employee);
				return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
			}
}
