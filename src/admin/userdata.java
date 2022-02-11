package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptorMBean;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class userdata
 */
@WebServlet("/userdata")
public class userdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	//	PrintWriter ps = response.getWriter();
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
			Statement pss = con.createStatement();
			ResultSet rds = pss.executeQuery("select * from hey");
			
			PrintWriter out = response.getWriter();
			
			  out.println("<table border=1 width=50% height=50%>");  
	             out.println("<tr><th>User Name</th><th>Email</th><th>Password</th><tr>");  
	             out.println("User name and password matches");
	             while (rds.next()) 
	             {  
	           
	            	// RequestDispatcher rq = request.getRequestDispatcher();
	            	// rq.include(request, response);
	            	 
	            	 
                 String un = rds.getString("uname");  
	              
	                 
	              String em = rds.getString("email");  
	              String ps2 = rds.getString("pass"); 
	              
	              out.println("<tr><td>" + un + "</td><td>" + em + "</td><td>" + ps2 + "</td></tr>");     
	            	 
	            	
	            
	             }  
	             out.println("</table>");  
	             out.println("</html></body>");  
	             con.close();  
	            
			
		}catch (Exception e) {
						e.printStackTrace();
		}
		
		
		
		
	}

	

}
