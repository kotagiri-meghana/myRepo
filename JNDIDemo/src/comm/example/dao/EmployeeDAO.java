package comm.example.dao;

import java.sql.Connection;
import java.util.List;

import comm.example.model.Employee;

public interface EmployeeDAO {
	
	public void createEmployee(Employee employee);

	public List<Employee> getEmployees();
	
	
	

}
