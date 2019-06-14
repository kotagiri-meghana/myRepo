package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection connection;
	private MyConnectionFactory myConnectionFactory;
	@Override
	
	
	
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement pStatement=connection.prepareStatement("insert into employee values(?,?,?,?)");
			
			pStatement.setInt(1, employee.getEmployeeId());
			pStatement.setString(2, employee.getFirstName());
			
			pStatement.setString(3, employee.getLastName());
			pStatement.setInt(4, employee.getSalary());
			int i=pStatement.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public EmployeeDAOImpl() {
		super();
		
		myConnectionFactory=MyConnectionFactory.getMyConnectionFactory();
		
		connection=myConnectionFactory.connection;
		
		
	}

}
