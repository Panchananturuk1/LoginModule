package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRows;
import com.mysql.cj.xdevapi.Result;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String uname, pass,email;
	String sql = "select * from adminn where uname=? and pass=?";
	
	public boolean validate(String uname, String pass){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
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
		PrintWriter out = response.getWriter();
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		//email = request.getParameter("email");

		 adminLogin ad = new adminLogin();

		if(ad.validate(uname, pass)){
			
			HttpSession s = request.getSession();
			s.setAttribute("username", uname);
			//response.sendRedirect("userdata.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("userdata");
			rd.forward(request, response);
		}else{
			out.println("user name and password is wrong");
			
			 out.println("<script type=\"text/javascript\">");
             out.println("alert('User name or password is incorrect');");
        
             out.println("</script>");
			
			RequestDispatcher rs2 = request.getRequestDispatcher("/admin.jsp");
			rs2.include(request, response);
		}
			
	}

}
