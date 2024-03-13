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
@WebServlet("/ValidateStudent")
public class ValidateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t3");
		String password=request.getParameter("t4");
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
			ResultSet rs=st.executeQuery("select * from Studentlogin where Username='"+name+"' And Password='"+password+"'");
		    if(rs.next())
		    	response.sendRedirect("student1.html");
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
