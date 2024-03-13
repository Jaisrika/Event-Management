package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3309/EventManagement","root","tiger");
			out.println("connection established");
			
			
			String id=request.getParameter("del");
		
			PreparedStatement ps3 = con.prepareStatement("DELETE FROM EventDetails WHERE name=?");
			ps3.setString(1, id);
			
			ps3.execute();
			out.println("Student data deleted successfully!");
			response.sendRedirect("admindone1.html");
			con.close();
			
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
