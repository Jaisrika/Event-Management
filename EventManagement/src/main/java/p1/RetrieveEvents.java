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
 * Servlet implementation class RetrieveEvents
 */
@WebServlet("/RetrieveEvents")
public class RetrieveEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveEvents() {
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
			Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3309/EventManagement","root","tiger");
			Statement st=con.createStatement();
			
		
			
			ResultSet rs=st.executeQuery("select * from Eventdetails;");
			response.setContentType("text/html");
			out.println("<html><body>");
            out.println("<h2>Events Details</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Event Name</th><th>Event Type</th><th>Guests</th><th>Coordinators</th><th>Faculty</th><th>Winners</th><th>Date</th><th>Start Time</th><th>End Time</th></tr>");
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                String Eventtype = rs.getString("Eventtype");
                String guests = rs.getString("guests");
                String coordinators = rs.getString("coordinators");
                String faculty = rs.getString("faculty");
                String winners = rs.getString("winners");
                String dat = rs.getString("dat");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                
                
                // Display values
                out.println("<tr><td>" + name + "</td><td>" + Eventtype + "</td><td>" + guests + "</td><td>" + coordinators + "</td><td>" + faculty + "</td><td>" + winners + "</td><td>" + dat + "</td><td>" + starttime + "</td><td>" + endtime + "</td></tr>");
            }
            
            out.println("</table>");
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            con.close();
			
			
			con.close();
	    }
	    catch(Exception e) {
	    	out.println(e);
	    }
		
	}

}
