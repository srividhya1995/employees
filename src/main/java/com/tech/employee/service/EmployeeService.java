package com.tech.employee.service;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.employee.dao.EmployeeDao;
import com.tech.employee.entity.Employee;
import com.tech.employee.exception.AgeException;
import com.tech.employee.exception.EmptyException;
import com.tech.employee.exception.SalaryNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String addEmployeeList(List<Employee> emp) {
		return empDao.addEmployeeList(emp);

	}

	public Employee findEmployee(int id) {
		return empDao.findEmployee(id);
	}

	public List<Employee> findemplist() {
		return empDao.findemplist();
	}

	public String deletebyid(int id) {
		return empDao.deletebyid(id);
	}

	public String updateemployee(Employee id) {
		return empDao.updateemployee(id);
	}

	public String gethighsalaryemployeename() {
		List<Employee> emp = empDao.findemplist();
		Employee max = emp.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
		return max.getName();
	}

	public String checkage(int age) {
		if (age > 18) {
			return "WECOME";
		} else
			return "you are not eligible to use this app";
	}

	public String checkage1(int age) {
		if (age > 18) {
			return "you are eligible to use this app";
		} else
			return "you are not eligible";

	}

	public List<Employee> checkname() {
		List<Employee> emp = empDao.findemplist();
		return emp.stream().filter(x -> x.getName().equalsIgnoreCase("srividhya")).toList();
	}

	public List<Employee> findagebycondition() {
		return empDao.findemplist().stream().filter(x -> x.getAge() > 27 && x.getAge() < 30).toList();
	}

	public List<Employee> findsalaryrange() {
		return empDao.findemplist().stream().filter(x -> x.getSalary() > 50000 && x.getSalary() < 70000).toList();
	}

	public Employee minsalaryemployeedetails() {
		return empDao.findemplist().stream().min(Comparator.comparingInt(Employee::getSalary)).get();
	}

	public List<Employee> getEmployeeByName(String name) throws EmptyException, Exception {
		List<Employee> emp = empDao.findemplist();
		List<Employee> e = emp.stream().filter(x -> x.getName().equalsIgnoreCase(name)).toList();
		if (e.isEmpty()) {
			throw new EmptyException("There is no match found by your name");
		} else {
			return e;
		}
	}

	public List<Employee> getByAge(int age) {
		return empDao.getByAge(age);
	}

	public List<Employee> getByName(String name) {
		return empDao.getByName(name);
	}

	public List<Employee> getBySalary(int salary) throws SalaryNotFoundException,Exception {
		List<Employee> emp= empDao.getBySalary(salary);
		List<Employee> e=emp.stream().filter(x->x.getSalary()>90000).toList();
		if(e.isEmpty()) {
			throw new SalaryNotFoundException("No one gets this amount as salary");
		}
		else {
			return e;
		}
	}

	public List<String> getNameByGender(String gender) {
		List<Employee> emp = empDao.findemplist();
		return emp.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).map(x -> x.getName()).toList();

	}

	public Employee getSeniorEmployee() {
		return empDao.getSeniorEmployee();
	}

	public Employee getJuniorEmployee() {
		return empDao.getJuniorEmployee();
	}

	public String addEmployee1(Employee e) throws AgeException, Exception {
		try {
			if (e.getAge() < 18) {
				throw new AgeException("YOU ARE NOT ELIGIBLE TO ADD THIS");
			} else {
				return empDao.addEmployee1(e);
			}
		} catch (AgeException ae) {
			return "this age is not allowed";
		}

	}
	public List<String> getNameByAge(int age) {
		return empDao.getNameByAge(age);
		
		
	}

}
