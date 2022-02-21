package admin;
import java.io.IOException;
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
import javax.servlet.http.HttpSession;

@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In do post method of Display Image servlet.");
		String img=request.getParameter("image");
		int imageid=Integer.parseInt(img);
		
		//getting database connection (jdbc code)
				Connection connection=null;
				int imgId=0;
				String imgFileName=null;
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
					Statement stmt;
					String query="select * from hey";
					stmt=connection.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					
					while(rs.next())
					{
						if(rs.getInt("id")==imageid)
						{
							imgId=rs.getInt("id");
							imgFileName=rs.getString("imgName");
						}
					}
						
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				
				RequestDispatcher rd;
				
				request.setAttribute("id",String.valueOf(imgId));  //valueOf
				request.setAttribute("img",imgFileName);
				rd=request.getRequestDispatcher("UserData.jsp");
				rd.forward(request, response);
			
			

	}

}
