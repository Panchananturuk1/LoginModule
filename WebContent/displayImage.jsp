<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Image</title>
</head>
<body>
<h1 style="color:red" align="center">DISPLAY IMAGE DETAIL</h1>

<div align="center">

<form action="DisplayServlet" method="post">
   Enter Image Id :
   <input type="number" name="imageId">
   <input type="submit" value="Display Image">
</form>

</div>

<hr>

<%
    String imgFileName=(String)request.getAttribute("img");
    String imgId=(String)request.getAttribute("id");
    System.out.println(imgFileName);
%>

<div align="center">
     <table border="5px" style="width:600px">
          <tr>
              <th>Image Id </th>
              <th>Image</th>
          </tr>
         
         <%
             if(imgFileName!="" && imgId!="")
             {
         %>
          
          <tr>
              <td><%=imgId %></td>
              <td><img src="img2/<%=imgFileName%>" style="width:300px;height:250px"></td>
          </tr>
        <%
             }
        %>  
     </table>
</div>

</body>
</html>