package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

@WebServlet("/controller.do1")
public class EmployeeController1 extends HttpServlet {

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
		List<String> l=new ArrayList<String>();
		try {
		eId = Integer.parseInt(req.getParameter("e_id"));
		}
		catch(Exception e)
		{
			l.add("id field must benumeric");
		}
		firstName = req.getParameter("e_fname");
		if(firstName.length()<=0)
		{
			l.add("First Name field can't be blank");
		}
		lastName = req.getParameter("e_lname");
		if(lastName.length()<=0)
		{
			l.add("First Name field can't be blank");
		}
		
		try {
			salary = Integer.parseInt(req.getParameter("e_sal"));
			}
			catch(Exception e)
			{
				l.add("salary field must benumeric");
			}
		
		if(!l.isEmpty())
		{
			req.setAttribute("ERROR",l );
			RequestDispatcher view=req.getRequestDispatcher("add_employee.jsp");
			view.forward(req, resp);
		}
		else {
			Employee employee = new Employee(eId, firstName, lastName, salary);
			eService.createEmployee(employee);
			req.setAttribute("E", employee);
			RequestDispatcher view=req.getRequestDispatcher("success.jsp");
			view.forward(req, resp);
		}
		
		

	}

}
