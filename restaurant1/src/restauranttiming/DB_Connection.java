package restauranttiming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB_Connection {

	 static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
     static final String DB_URL="jdbc:mysql://localhost/restaurant1";

     //  Database credentials
     static final String USER = "root";
     static final String PASS = "ssn";
     public Statement getstatement()
     {
     Connection conn=null;
     Statement stmt=null;
		try {
			//items = upload.parseRequest((RequestContext) request);
			  Class.forName("com.mysql.jdbc.Driver");
	
	           // Open a connection
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	           // Execute SQL query
	            stmt = conn.createStatement();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return stmt;
     }
}
