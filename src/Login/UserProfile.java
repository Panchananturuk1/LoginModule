package Login;

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
import javax.servlet.http.Part;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptorMBean;

import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class userdata
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");  
		
//		   String imageId = request.getParameter("image");
//    		int id = Integer.parseInt(imageId);
		
//    		int imgId = 0;
//    		String imgFilename;
		
		
		
    		
		try{
			
			String uname, pass;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
//			Statement pss = con.createStatement();
			PreparedStatement pss = con.prepareStatement("select * from hey where uname=? and pass=?");
			
			uname = request.getParameter("uname");
			 pass = request.getParameter("pass");
			
			pss.setString(1, uname);
			pss.setString(2, pass);
			ResultSet rds = pss.executeQuery();
			
			
				
			
				
	             
	            
	             
	             
	          
	             
	             
	             
	          
	             int serial_no=0;
	             
	            
	             if (rds.next()) 
	             {  
	            	 
	            	 out.println("<script type=\"text/javascript\">");
		             out.println("alert('User name or password is correct');");
		             out.println("</script>");
       	           
	            	// serial_no++;
	              String un = rds.getString("uname");  
	              String em = rds.getString("email");  
	              String ps2 = rds.getString("pass"); 
	              String gens = rds.getString("gender"); 
	              String img = rds.getString("imgName");  
	              
	              
	        //      String imgFileName=(String)request.getAttribute("img");
	          //    String imgId=(String)request.getAttribute("id");
	              
	              
	       
	              
	           
	            	//int  imgId=rds.getInt("img");
	            	// String imgFilename = rds.getString("imgName");
	            	  
	          //    int imgId = Integer.parseInt(rds.getString("imgName"));  
	              
	              out.println("<table border=1 width=50% height=50%>");  
		             out.println("<tr><th>SL No</th><th>User Name</th><th>Email</th><th>Password</th><th>Gender</th><th>Image Name</th><th>Image</th><tr>");  
		             
	              out.println("<tr><td>" + serial_no + "</td><td>" + un + "</td><td>" + em + "</td><td>" + ps2 + "</td><td>" + gens +"</td><td>" + img + "</td><td><img src='img2/"+ img + "' style='width:50px;height:50px'></td></tr>");     
	            
	             
	              																			
	             } else {
	            	 out.println("<script type=\"text/javascript\">");
		             out.println("alert('User name or password is wrong');");
		             out.println("</script>");
		          
		             RequestDispatcher rss = request.getRequestDispatcher("login.jsp");
		             rss.include(request, response);
		             
	             }
	             
	             out.println("</table>");  
	             
	             
	             out.println("<input type='submit' name='logout' value='Logout'"); 

	             out.println("</html></body>");  
	             con.close();  
	            
			
				}catch (Exception e) {
						e.printStackTrace();
						out.println("ERROR ");
					}

	}

	

}
