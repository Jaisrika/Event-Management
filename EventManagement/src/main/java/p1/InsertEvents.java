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
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertStudent")
public class InsertEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("name");
			String Eventtype=request.getParameter("Eventtype");    
			String guests=request.getParameter("guests");  
			String coordinators=request.getParameter("coordinators");  
			String faculty=request.getParameter("faculty");  
			String winners=request.getParameter("winners");  
			String dat = request.getParameter("dat");
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			
			
	      	Class.forName("com.mysql.cj.jdbc.Driver");
	      	Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3309/EventManagement","root","tiger");
	      	Statement st=con.createStatement();
	      	int i=st.executeUpdate("insert into EventDetails values('"+name+"','"+Eventtype+"','"+guests+"','"+coordinators+"','"+faculty+"','"+winners+"','"+dat+"','"+starttime+"','"+endtime+"');");
	      	if(i>0)
		    	response.sendRedirect("admindone.html");
		    else
		    	out.println("Incorrect Username and password:");
	      	con.close();
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
