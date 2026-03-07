package hcl.springboot.springbootproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hcl.springboot.springbootproject.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(name = "Employee.findByName")
	public List<Employee> findByName(@Param("empName") String empName);
	
}
