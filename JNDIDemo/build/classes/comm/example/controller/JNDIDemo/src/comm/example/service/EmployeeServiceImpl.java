package comm.example.service;

import java.util.ArrayList;
import java.util.List;

import comm.example.dao.EmployeeDAO;
import comm.example.dao.EmployeeDAOImpl;
import comm.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO empDao;

	public EmployeeServiceImpl() {
		super();

		empDao = new EmployeeDAOImpl();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
		empDao.createEmployee(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		System.out.println("in service");
		List<Employee> l=new ArrayList<Employee>();
		EmployeeDAO empDao1 = new EmployeeDAOImpl();
		l=empDao1.getEmployees();
		for(Employee e:l) {
			System.out.println(e.toString());
		}
		System.out.println("after service");
		return l;
	}

}
