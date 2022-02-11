package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Login.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	public static final long serialVersionUID= 1L;
	String sql = "select * from hey where uname=? and pass=?";
	String uname, pass;

	public boolean checks(String uname, String pass){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");//or ==> (url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			
		
			
						
			if(rs.next()){
				return true;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		uname = request.getParameter("uname");
		 pass = request.getParameter("pass");
		 PrintWriter ps = response.getWriter();
		
		Login dao = new Login();
		
		
		//if(uname.equals("monu") && pass.equals("123") ){
		
		if(dao.checks(uname,pass)){
			
			ps.println("user ane and password is correct");
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");  
			
			//RequestDispatcher rss2 = request.getRequestDispatcher("welcome.jsp");
			//rss2.forward(request, response);
			
		}else
			{
			
				ps.println("Users Name & Password is wrong !");
				RequestDispatcher rss = request.getRequestDispatcher("/login.jsp");
				rss.include(request, response);
				
				//response.sendRedirect("login.jsp");
				
			
			}
		
		

		
		
		
		
	}



}



/* ANOTHER METHOD OF CHECKING */



//LoginDao dao = new LoginDao();
//
//// if(uname.isEmpty() || pass.isEmpty() )
// if(dao.checks2(uname, pass))
// {
//           RequestDispatcher rss = request.getRequestDispatcher("welcome.jsp");
//           rss.include(request, response);
// }
// else
// {
//           RequestDispatcher rss =       request.getRequestDispatcher("index.jsp");
//           rss.forward(request, response);
//          
// }
