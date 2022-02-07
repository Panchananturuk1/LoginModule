package Register;

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

//import Login.Login;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String username , emails, password1,password2;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 username = request.getParameter("uname");
		 emails = request.getParameter("email");
		 password1 = request.getParameter("pass");
		 password2 = request.getParameter("pass2");
		
		 
	 PrintWriter out = response.getWriter();
//		 out.println(username);
//		 out.println(emails);
//		 out.println(password1);
		 
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
			 String sql = "insert into hey(uname,email,pass,pass2) values(?,?,?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1,username);
			 ps.setString(2,emails);
			 ps.setString(3,password1);
			 ps.setString(4,password2);
			 
			// ResultSet rs = ps.executeQuery();
			 ps.executeUpdate();
			 out.println("User Sucessfully Registered");
			// response.sendRedirect("login.jsp");
			 
			 
		 }catch(Exception e){
			 e.printStackTrace(); 
		 }
		 
	}

}
