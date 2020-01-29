package restauranttiming;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

public class itemadd extends HttpServlet{

	 static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
     static final String DB_URL="jdbc:mysql://localhost/restaurant1";

     //  Database credentials
     static final String USER = "root";
     static final String PASS = "ssn";
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		
		//System.out.println("Attribute : "+ request.getAttribute("footype"));
		System.out.println("getParameter : "+ request.getParameter("footype"));
		//ServletContext context = pageContext.getServletContext();
		
		   String filePath = getServletContext().getInitParameter("file-upload");
		  System.out.println(filePath);
		  String footype="";
          String Itemname="";
          String link="";
          String desc="";
          int price=0;
          Connection conn=null;
          Statement stmt=null;
		try {
			//items = upload.parseRequest((RequestContext) request);
			  Class.forName("com.mysql.jdbc.Driver");

	            // Open a connection
	             conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            // Execute SQL query
	             stmt = conn.createStatement();
		  List<FileItem> items =  new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request)); 
      	//System.out.println(items);
	        for (FileItem item : items) {
	        	
	        	String fieldName = item.getFieldName();
	            String value = item.getString();
	           
	            if(fieldName.equalsIgnoreCase("footype"))
	            {
	            	footype=value;
	            }
	            else if(fieldName.equalsIgnoreCase("item"))
	            {
	            	Itemname=value;
	            }
	            else if(fieldName.equalsIgnoreCase("desc"))
	            {
	            	desc=value;
	            }
	            else if(fieldName.equalsIgnoreCase("price"))
	            {
	            	price=Integer.parseInt(value);
	            }
	            else if(fieldName.equalsIgnoreCase("image"))
	            {
	            //System.out.println("Field Name : "+fieldName+ " Value : " +value);
	                SimpleDateFormat sdf = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
	                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	                link=filePath+sdf.format(timestamp)+".jpg";
		        	 File Dest =new File(link);
		        	try {
						item.write(Dest);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
	            }
	          

	            } 
	        
	        System.out.println("Footype  : " +footype);
            System.out.println("Item Name :" + Itemname);
            System.out.println("Image Link :" +link.replace("\\", "\\\\"));
            System.out.println("Description : "+desc);
            System.out.println("Price  :" +price);
            int cid=(int)request.getSession().getAttribute("cuisineid");
            System.out.println(cid);
          
            String sql;
             sql = "INSERT INTO menu_items(cid,food_group,name,image,description,price) VALUES("+cid+",'"+footype+"','"+Itemname+"','"+link+"','"+desc+"',"+price+")";
   	         int rs1 = stmt.executeUpdate(sql);
            System.out.println(rs1);
            
            sql= "select * from menu_items where cid="+cid;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
            	
            }
            response.sendRedirect("menu.jsp");
		} catch (FileUploadException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	public ResultSet getname(String uid)
	{
		ResultSet rs=null;
		System.out.println(uid);
		DB_Connection db=new DB_Connection();
		Statement stmt=db.getstatement();
		 String sql="select name from menu_items where cid="+uid;
         try {
        	 rs=stmt.executeQuery(sql);
			//System.out.println("deleted row count : "+rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println(rs);
		return rs;
	}
	
}
