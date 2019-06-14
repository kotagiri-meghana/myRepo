package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

@WebServlet("/controller.do")
public class EmployeeController extends HttpServlet {

	private int eId;
	private String firstName, lastName;
	private int salary;

	private EmployeeService eService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		eService = new EmployeeServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		eId = Integer.parseInt(req.getParameter("e_id"));

		firstName = req.getParameter("e_fname");
		lastName = req.getParameter("e_lname");
		salary = Integer.parseInt(req.getParameter("e_sal"));
		
		Employee employee = new Employee(eId, firstName, lastName, salary);
		
		eService.createEmployee(employee);
		
		out.println("employee added succesfully");
		
		List<Employee>  l=new ArrayList<Employee>();
		EmployeeService eService1 = new EmployeeServiceImpl();
		l=eService1.getEmployees();
		String s = null;
		for(Employee e:l) {
			s=s+e.toString();
		}
		
		
		
		
		
		out.println("<html><head><script>function fun(){ document.getElementById('l').innerHTML='"+s+"'}</script></head><body>");
		
		out.println("<h3 onclick='fun()'>List the employee</h3>");
		out.println("<d id='l'></d>");
		out.println("</body></html>");
		

	}

}
