package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateAdmin
 */
@WebServlet("/ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		String password=request.getParameter("t2");
		try {
			//1. Loading a Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("Driver class Loaded");
			//2.establish a connection
			Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3309/EventManagement","root","tiger");
			out.println("connection established");
			//3.prepare statement
			Statement st=con.createStatement();
			//4.prepare and submit the query 
			ResultSet rs=st.executeQuery("select * from Adminlogin where Username='"+name+"' And Password='"+password+"'");
		    if(rs.next())
		    	response.sendRedirect("admin1.html");
		    else
		    	out.println("Incorrect Username and password:");

		}
		catch(Exception e) {
			out.println(e);
		}
		
		
//		out.println(name);
//		out.println(password);
	}

}
