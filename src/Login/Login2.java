package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.LoginDao;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  String uname,pass;
  
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		
//		try {
//			Class.forName("com.jdbc.mysql.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
//			//String sql = "select * from hey where uname=? and pass=?";
//
//			PreparedStatement st = con.prepareStatement("select * from hey where uname=? and pass=?");
//			st.setString(1, uname);
//			st.setString(2, pass);
//			ResultSet rs = st.executeQuery();
//			
//			PrintWriter out= response.getWriter();
			
			
			
			
			
			LoginDao dao = new LoginDao();
			
			if(dao.checks2(uname,pass))
			{
				
				
				out.println("user name and password is correct");
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				session.setAttribute("password", pass);
								
				response.sendRedirect("UserProfile.jsp");
	
					
					
				}else{
					out.println("Users Name & Password is wrong !");
					RequestDispatcher rss = request.getRequestDispatcher("/login.jsp");
					rss.include(request, response);
				}
			}
			
			
			
			
			
			
		//	out.println("Logged INNNNNNNNNNNNNN");
			
//			if(rs.next()){
//				ps.println("SUCESSFULLY");
//				//response.sendRedirect("Register.jsp");
//			}else
//			{
//				ps.println("UNSUCESSFULL");
//			}
			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//		
//			ps.print("error");
//		}
		
		
		
	}

//}
