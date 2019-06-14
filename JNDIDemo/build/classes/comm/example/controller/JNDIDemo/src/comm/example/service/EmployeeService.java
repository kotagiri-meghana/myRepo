package comm.example.service;

import java.util.List;

import comm.example.model.Employee;

public interface EmployeeService {
	public void createEmployee(Employee employee);

	public List<Employee> getEmployees();

}
