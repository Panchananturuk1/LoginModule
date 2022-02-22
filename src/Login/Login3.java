package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/Login3")
public class Login3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String sql = "select * from hey where uname=? and pass=?";
  String username,pass,gender;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		username = request.getParameter("uname");
		pass = request.getParameter("pass");
		gender = request.getParameter("gen");
		PrintWriter ps = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");//or ==> (url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			
			
			
			if(rs.next()){
				ps.println("Welcome: "+username);
				//response.sendRedirect("Register.jsp");
				
				ps.println("<br>"+" Name: "+username);
				ps.println("<br>"+"Password: "+pass);
				ps.println("<br>"+"Gender: "+gender);
				
			}else
			{
				ps.println("UNSUCESSFULL");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ps.println("CATCH BLOCK");
		}
		
		
		
	}

}
