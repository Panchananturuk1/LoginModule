package Register;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.OutputBuffer;
import org.apache.jasper.tagplugins.jstl.core.Out;

//import Login.Login;

@MultipartConfig

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String username , emails, password1,password2, gender, Interest,img,filename;
	//Part part;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 
		 response.setContentType("text/html");
		 username = request.getParameter("uname");
		 emails = request.getParameter("email");
		 password1 = request.getParameter("pass");
		 password2 = request.getParameter("pass2");
		 gender = request.getParameter("gen");
		 Interest = request.getParameter("Interest");
		 Part part = request.getPart("image");

		 filename = part.getSubmittedFileName();

		 
//		 int imgeId=0;
//		  String imgFilename=null;
		 
		 
//		 out.println(username);
//		 out.println(emails);
//		 out.println(password1);
		 
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
			 String sql = "insert into hey(uname,email,pass,pass2,gender,Interest,imgName) values(?,?,?,?,?,?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1,username);
			 ps.setString(2,emails);
			 ps.setString(3,password1);
			 ps.setString(4,password2);
			 ps.setString(5,gender);
			 ps.setString(6,Interest);
			 ps.setString(7, filename);
			 //ps.setString(7, path);
			 
			 
			// ResultSet rs = ps.executeQuery();
			 int row = ps.executeUpdate();
			 if(row>0){
			 out.println("User Sucessfully Registered");
			// response.sendRedirect("login.jsp");

			 }
						 
			 //upload
			 
			InputStream is = part.getInputStream();
			byte []data = new byte[is.available()];
			is.read(data);
			
		//	String path= request.getRealPath("/")+"dp"+File.separator+filename; // the dile is ttoring in webaptpp in apacheserver folder so i choose another method
//			String path = getServletContext().getRealPath("/"+"dp"+File.separator+filename);
			
			
			String path= "C:/Users/MONU/Desktop/Eclipse/LoginModule/dp/"+filename;
						
			//out.println(path);

			FileOutputStream fout = new FileOutputStream(path);
			fout.write(data);
			fout.close(); 
			 
			 
			 
		 }catch(Exception e){
			 e.printStackTrace(); 
			 out.println("ERROR");
		 }
		 
	}

}
