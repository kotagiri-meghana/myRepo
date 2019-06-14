package comm.example.service;

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

}
