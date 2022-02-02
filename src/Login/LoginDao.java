package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	
	String sql = "select * from employee where username=? and pass=?";
	
	//String ResultSet rs= st.ExecuteQuery("");
	//String url= "jdbc:mysql://localhost:3036:/mydb";
	//String username = "root";
	//String password = "1234";
	
	public boolean check(String uname, String pass){
	
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
