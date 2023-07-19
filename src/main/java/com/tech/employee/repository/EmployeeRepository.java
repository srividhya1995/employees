package com.tech.employee.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select *from employees where age>=?",nativeQuery=true)
	public List<Employee> getByAge(int age);
	@Query(value="select *from employees where name like ?",nativeQuery=true)
	public List<Employee> getByName(String name);
	@Query(value="select *from employees where salary>=?",nativeQuery=true)
	public List<Employee> getBySalary(int salary);
	@Query(value="select*from employees where gender like ?",nativeQuery=true)
	public List<String> getNameByGender(String gender);
	@Query(value="select * from employees where id=(select min(id) from employees)",nativeQuery=true)
	public Employee getSeniorEmployee();
	@Query(value="select * from employees where id=(select max(id) from employees)",nativeQuery=true)
	public Employee getJuniorEmployee();
	@Query(value="select name from employees where age>=?",nativeQuery=true) 
	public List<String> getNameByAge(int age);

}
