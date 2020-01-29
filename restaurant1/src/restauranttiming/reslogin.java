package restauranttiming;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class reslogin extends HttpServlet{
    
public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException
  {
      // JDBC driver name and database URL
      final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost/restaurant1";

      //  Database credentials
      final String USER = "root";
      final String PASS = "ssn";
	
	Statement stmt=null;
	Connection conn =null;

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";


     
      try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
         String sql;
         String uname=request.getParameter("uname");
         String pass=request.getParameter("password");
         sql = "SELECT catagory,id,hotelname,branch FROM register where password='"+pass+"' and name='"+uname+"'";
         ResultSet rs = stmt.executeQuery(sql);

         
          int flag=0;
         while(rs.next()){
            String c=rs.getString(1);
            System.out.println(c);
            int id=rs.getInt(2);
            System.out.println("id : " +id);
            HttpSession session=request.getSession();
            session.setAttribute("userid", id);
            String hotelname=rs.getString(3);
            String branch=rs.getString(4);
            
            if(c.equalsIgnoreCase("Owner") )
            {
            	
            	 sql = "SELECT id FROM halfmenu where userid="+id;
            	 System.out.println(sql);
                 ResultSet rs1 = stmt.executeQuery(sql);
                 session.setAttribute("hotelname", hotelname);
                 session.setAttribute("branch", branch);
                 while(rs1.next())
                 {
                	 id=rs1.getInt(1);
                	 
                	 System.out.println("hotelname : "+hotelname);
                	 System.out.println("Custid : "+id);
    	             
    	             session.setAttribute("cuisineid", id);
    	             
    	             flag=1;
    	             response.sendRedirect("Halfmenu.jsp");
    	             break;
                 }
              //out.println("<html><body b ><a href='3.html'>Click here to Enter Details</a></body></html>");
            	if(flag==0)
            	{
            		flag=1;
            		response.sendRedirect("Halfmenu1.jsp");
            		break;
            	}
             
              
            }
            else if (c.equalsIgnoreCase("Customer"))
            {
            	// HttpSession session=request.getSession();
	             session.setAttribute("userid", c);
            	response.sendRedirect("customer.jsp");
                flag=1;
                break;
            }
             
                                     
         }
         if(flag==0)
         {
        	 
        	 request.setAttribute("message", "Invalid Login Please Retry!!");
          	 System.out.println(request.getAttribute("message"));
        	 response.sendRedirect("Login.jsp?message=Invalid Login Please Retry!!");
         //out.println("Invalid Login Please Retry!!");
         }
         

         // Clean-up environment
        // rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }finally{
         //finally block used to close resources
         try{
            if(stmt!=null)
               stmt.close();
         }catch(SQLException se2){
         }// nothing we can do
         try{
            if(conn!=null)
            conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }//end finally try
      } //end try
   }
} 
