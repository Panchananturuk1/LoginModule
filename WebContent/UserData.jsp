<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //  http 1.1
	response.setHeader("Pragma","no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxy
	session.getAttribute("Password");
	session.getAttribute("Email");
	
		if(session.getAttribute("username")==null){
			
			response.sendRedirect("admin.jsp");
		}
	%>
	
	<script>alert("Credential Matching");</script>
	hey ${username} Welcome /............ <br>
	
	<table border="1">
		<tr>
		<td> ID:</td> 
		 <td> User Name:</td> 
		 <td> Email: </td> 
		 <td> Password:  </td> 
		 <td> Gender:</td> 
		 <td> Interested: </td> 
		 <td> Image Name:  </td> 
		 <td> Image </td> 
		 
		 
		</tr>
	
	
	<%
		String us =request.getParameter("uname");
	String em =request.getParameter("email");
	String ps =request.getParameter("pass");
	 String gens =request.getParameter("gender"); 
	 String intr =request.getParameter("Interest"); 
     String img = request.getParameter("imgName");  
     
    // String imgFileName=(String)request.getAttribute("img");
	 // String imgId=(String)request.getAttribute("id");
    
  
	
	
	Connection con =null;
	Statement st = null;
	ResultSet rs=null;
	
	
	try{
		
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
		
		st=con.createStatement();
		String qry = "select * from hey";
		rs=st.executeQuery(qry);
		
		while(rs.next())
		{
			
		//	out.print("User Name" + rs.getString(1)+"Email:"+rs.getString(2)+"Password:"+rs.getString(3) );
		%>
		<tr>
			<td><%=rs.getString(1) %> </td>
			<td><%=rs.getString(2) %> </td>
			<td><%=rs.getString(3) %> </td>
			<td><%=rs.getString(4) %> </td>
			<td><%=rs.getString(6) %> </td>
			<td><%=rs.getString(7) %> </td>
			<td><%=rs.getString(8) %> </td>
			<td><img src="img2/<%=rs.getString(8) %>" style="width:50px;height:50px"></td>

		
			
			<%
		}
		
		
		
	}catch(Exception e){
		
	}
	
	
	
	%>
	</table>





</body>
</html>