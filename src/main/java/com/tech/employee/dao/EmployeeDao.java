package com.tech.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.employee.entity.Employee;
import com.tech.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully Saved";
	}
	public String addEmployeeList(List<Employee> emp) {
		empRepo.saveAll(emp);
		return "Successfully added";
	}
	public Employee findEmployee(int id) {
		return empRepo.findById(id).get();
		
	}
	public List<Employee> findemplist() {
		return empRepo.findAll();
		
	}
	public String deletebyid(int id) {
		empRepo.deleteById(id);
		return "deleted successfully";
	}
	public String updateemployee(Employee emp) {
		empRepo.save(emp);
		return "Updated Successfully";
	}
	public List<Employee> getByAge(int age) {
		return empRepo.getByAge(age);
	}
	public List<Employee>getByName(String name) {
		return empRepo.getByName(name);
	}
	public List<Employee> getBySalary(int salary) {
		return empRepo.getBySalary(salary);
	}
	public List<String>getNameByGender(String gender) {
		return empRepo.getNameByGender(gender);
	}
	public Employee getSeniorEmployee() {
		return empRepo.getSeniorEmployee();
	}
	public Employee getJuniorEmployee() {
		return empRepo.getJuniorEmployee();
	}
	public String addEmployee1(Employee e) {
		empRepo.save(e);
		return "succesfully Added";
	}
	public List<String> getNameByAge(int age) {
		return empRepo.getNameByAge(age);
	}
	


}
