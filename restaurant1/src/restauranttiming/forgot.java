package restauranttiming;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class forgot extends HttpServlet{
    
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
            String name = request.getParameter("uname");
            //String id  = request.getParameter("id");
           // String oldpwd = request.getParameter("opwd");
            String newpwd = request.getParameter("npwd");
            //String password = request.getParameter("password");

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
         /*sql = "SELECT count(*) FROM register where name='"+name+"'";
         ResultSet rs = stmt.executeQuery(sql);

         
          int flag=0;
         while(rs.next()){
            int c=rs.getInt(1);
            if(c == 0 )
            {*/
	         sql = "UPDATE register set password='"+newpwd+"' where name='"+name+"'";
	         int rs1 = stmt.executeUpdate(sql);
	
	        //out.println("Update successfull");
	         response.sendRedirect("Login.jsp?message=Password Updated successfully");
	        
	        
	
	         // Clean-up environment
	         System.out.println("updated Record count:"+rs1);
           /*}
            else
            { 
            	response.sendRedirect("Register.jsp?message=Username already exist");
            }
         }*/
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