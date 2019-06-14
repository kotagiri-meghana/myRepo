package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> l=new ArrayList<Employee>();
		try {
			Statement s=connection.createStatement();
			ResultSet rs=s.executeQuery("select * from employee");
			
				
			
			while(rs.next()) {
				Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				System.out.println(e.toString());
				l.add(e);
				System.out.println("hi");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
