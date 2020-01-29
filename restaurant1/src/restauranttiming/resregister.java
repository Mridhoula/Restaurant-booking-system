package restauranttiming;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class resregister extends HttpServlet{
    
	 static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
     static final String DB_URL="jdbc:mysql://localhost/restaurant1";

     //  Database credentials
     static final String USER = "root";
     static final String PASS = "ssn";
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // JDBC driver name and database URL
	  //System.out.println("in");
     

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      /*String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");*/
            String name = request.getParameter("name");
            //String id  = request.getParameter("id");
            String address = request.getParameter("address");
            String pincode = request.getParameter("pincode");
            String password = request.getParameter("password");
            String mobno = request.getParameter("mobile");
            String email = request.getParameter("email");
           
          String catagory=request.getParameter("catagory");
          String hotelname=request.getParameter("hotelname");
          String hotelbranch=request.getParameter("hotelbranch");
            Connection conn=null;
            Statement stmt=null;
      try{ 
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
          conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
          stmt = conn.createStatement();
         String sql;
         sql = "SELECT count(*) FROM register where name='"+name+"'";
         ResultSet rs = stmt.executeQuery(sql);

         
          int flag=0;
         while(rs.next()){
            int c=rs.getInt(1);
            if(c == 0 )
            {
            	 /*HttpSession session=request.getSession();
            	 int uid=Integer.parseInt(session.getAttribute("userid").toString());
	             System.out.println(uid);*/
	         sql = "INSERT INTO register(name,address,pincode,password,mobno,email,catagory,hotelname,branch) VALUES('"+name+"','"+address+"','"+pincode+"','"+password+"','"+mobno+"','"+email+"','"+catagory+"','"+hotelname+"','"+hotelbranch+"')";
	         int rs1 = stmt.executeUpdate(sql);
	
	        //out.println("Register successfull");
	         response.sendRedirect("Login.jsp");
	
	         // Clean-up environment
	         System.out.println("updated Record count:"+rs1);
            }
            else
            {
            	response.sendRedirect("Register.jsp?message=Username already exist");
            }
         }
         
         //rs.close();
         /*stmt.close();
         conn.close();*/
      }catch(SQLException se){
         //Handle errors for JDBC
    	 
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      } //end try
   }
} 