package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginDao")
public class LoginDao {
	
	
	String sql = "select * from hey where uname=? and pass=?";
	
	
	public boolean checks2(String uname, String pass){
	
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

}
