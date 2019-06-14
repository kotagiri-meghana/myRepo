package comm.example;

import java.io.IOException;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			
			InitialContext cxt = new InitialContext();
			if ( cxt == null ) {
			   throw new Exception("Uh oh -- no context!");
			}

			javax.sql.DataSource ds = (javax.sql.DataSource) cxt.lookup( "java:/comp/env/jdbc/ibm" );
			response.getWriter().println(ds);
			if ( ds == null ) {
			   throw new Exception("Data source not found!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
