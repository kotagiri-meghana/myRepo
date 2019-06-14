package comm.example.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyConnectionFactory {
	
	public static  Connection connection;
	
	private static MyConnectionFactory myConnectionFactory;

	private  MyConnectionFactory() {
		super();
		
		try {
			
			Context context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup("java:/comp/env/jdbc/ibm");
			connection=dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
			
		}
		
		
		
		
		
	}
	public static MyConnectionFactory getMyConnectionFactory()
	{
		if(myConnectionFactory==null)
		{
			myConnectionFactory=new MyConnectionFactory();
		}
		return myConnectionFactory;
	}
	
	
	
	
	

}
