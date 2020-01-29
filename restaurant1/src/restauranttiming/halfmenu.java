package restauranttiming;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;



import java.sql.*;
 
public class halfmenu extends HttpServlet{
    
	 static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
     static final String DB_URL="jdbc:mysql://localhost/restaurant1";

     //  Database credentials
     static final String USER = "root";
     static final String PASS = "ssn";
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      HttpSession session=request.getSession();
  	
    String cuisine = request.getParameter("cuisine");
    String type   = request.getParameter("type");
    String ac = request.getParameter("temp");
    String catagory = request.getParameter("buffet");
    String seats= request.getParameter("seats");
    String hotelname=session.getAttribute("hotelname").toString();
    String branch=request.getParameter("branch");
    String single=request.getParameter("single");
    String small=request.getParameter("small");
    String large=request.getParameter("large");
    String family=request.getParameter("family");
    System.out.println("hotel name : " +hotelname);
    System.out.println("Branch : " +branch);
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
         //sql = "SELECT count(*) FROM register where name='"+name+"'";
         //ResultSet rs = stmt.executeQuery(sql);

         
         // int flag=0;
         //while(rs.next()){
           // int c=rs.getInt(1);
            //if(c == 0 )
            //{
	         int uid=Integer.parseInt(session.getAttribute("userid").toString());
	         System.out.println(uid);
	         sql = "INSERT INTO halfmenu(cuisine,type,ac,catagory,hotelname,userid,branch) VALUES('"+cuisine+"','"+type+"','"+ac+"','"+catagory+"','"+hotelname+"',"+uid+",'"+branch+"')";
	         int rs1 = stmt.executeUpdate(sql);
	         sql = "INSERT INTO hotel_capacity(hotelname,branch,table_type,table_no) VALUES('"+hotelname+"','"+branch+"','single',"+single+")";
	         rs1 = stmt.executeUpdate(sql);
	         sql = "INSERT INTO hotel_capacity(hotelname,branch,table_type,table_no) VALUES('"+hotelname+"','"+branch+"','small',"+small+")";
	         rs1 = stmt.executeUpdate(sql);
	         sql = "INSERT INTO hotel_capacity(hotelname,branch,table_type,table_no) VALUES('"+hotelname+"','"+branch+"','large',"+large+")";
	         rs1 = stmt.executeUpdate(sql);
	         sql = "INSERT INTO hotel_capacity(hotelname,branch,table_type,table_no) VALUES('"+hotelname+"','"+branch+"','family',"+family+")";
	         rs1 = stmt.executeUpdate(sql);
	         sql="select id from halfmenu where hotelname='"+hotelname+"' and branch='"+branch+"'";
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()){
	             int c=rs.getInt(1);
	             session.setAttribute("cuisineid", c);
	         
	         }
	         response.sendRedirect("menu.jsp");
	         
	        
	
	         // Clean-up environment
	        
            //else
            
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
