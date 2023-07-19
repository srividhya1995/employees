package com.tech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.employee.entity.Employee;
import com.tech.employee.exception.AgeException;
import com.tech.employee.exception.EmptyException;
import com.tech.employee.exception.SalaryNotFoundException;
import com.tech.employee.service.EmployeeService;

@RestController
public class EmployeeController  {
	@Autowired
	EmployeeService empser;
	
	@Autowired
	RestTemplate rt;
	@GetMapping(value="/getString")
	public String getString() {
		String url="http://localhost:8080/teacher/gettheString";
		ResponseEntity<String> s=rt.exchange(url, HttpMethod.GET,null,String.class);
		String x=s.getBody();
		return x.toUpperCase();
	}
	
	
	
	
	@PostMapping(value="/insertEmployee")
	public String addEmployee(@RequestBody Employee e) {
		return empser.addEmployee(e);
	}
	@PostMapping(value="/insertEmployeeList")
	public String addEmployeeList(@RequestBody List<Employee> emp) {
		return empser.addEmployeeList(emp);
	}
	@GetMapping(value="/findid/{id}")
	public Employee findEmployee(@PathVariable int id) {
		return empser.findEmployee(id);
	}
	@GetMapping(value="/getlistofemployees")
	public List<Employee> findemplist() {
		return empser.findemplist();
	}
	@GetMapping(value="/deletebyid/{id}")
	public String deletebyid(@PathVariable int id) {
		return empser.deletebyid(id);
	}
	@PutMapping(value="/updateemployee/{id}")
	public String updateemployee(@RequestBody Employee id) {
		return empser.updateemployee(id);
	}
	//modification
	@GetMapping(value="/highsalaryemployeename")
	public String gethighsalaryemployeename() {
		return empser.gethighsalaryemployeename();
	}
	@PostMapping(value="/checkage/{age}")
	public String checkage(@PathVariable int age) {
		return empser.checkage(age);
	}
	@PostMapping(value="/checkage1")
	public String checkage1(@RequestParam int age) {
		return empser.checkage1(age);
	}
	@GetMapping(value="/checkname")
	public List<Employee> checkname() {
		return empser.checkname();
	}
	@GetMapping(value="/findagebycondition")
	public List<Employee> findagebucondition() {
		return empser.findagebycondition();
	}
	@GetMapping(value="/findsalaryrange")
	public List<Employee> findsalaryrange() {
		return empser.findsalaryrange();
	}
	@GetMapping(value="/minsalaryemployeedetails") 
	public Employee minsalaryemployeedetails() {
		return empser.minsalaryemployeedetails();
	}
	@GetMapping(value="/getEmployeeByName") 
	public List<Employee> getEmployeeByName(@RequestParam String name) throws EmptyException,Exception {
		return empser.getEmployeeByName(name);
	}
	@GetMapping(value="/getByAge")
	public List<Employee> getByAge(@RequestParam int age) {
		return empser.getByAge(age);
	}
	@GetMapping(value="/getByName")
	public List<Employee>getByName(@RequestParam String name) {
		return empser.getByName(name);
	}
	@GetMapping(value="/getBySalary")
	public List<Employee>getBySalary(@RequestParam int salary) throws SalaryNotFoundException,Exception {
		return empser.getBySalary(salary);
	}
	@GetMapping(value="/getNameByGender")
	public List<String> getNameByGender(@RequestParam String gender) {
		return empser.getNameByGender(gender);
	}
	@GetMapping(value="/getSeniorEmployee")
	public Employee getSeniorEmployee() {
		return empser.getSeniorEmployee();
	}
	@GetMapping(value="/getJuniorEmployee")
	public Employee getJuniorEmployee() {
		return empser.getJuniorEmployee();
	}
	@PostMapping(value="/addEmployee1")
	public String addEmployee1(@RequestBody Employee e) throws AgeException,Exception {
		return empser.addEmployee1(e);
	}
	@GetMapping(value="/getNameByAge/{age}")
	public List<String> getNameByAge(@PathVariable int age) {
		return empser.getNameByAge(age);
	}
	//rest template example
	
	

}
