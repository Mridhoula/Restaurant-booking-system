package restauranttiming;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class itemdelete extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DB_Connection db=new DB_Connection();
		Statement stmt=db.getstatement();
		//String type=request.getParameter("type");
		String item=request.getParameter("item");
		//String desc=request.getParameter("desc").trim();
		//int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("item : "+item);
		 int cid=(int)request.getSession().getAttribute("cuisineid");
         System.out.println(cid);
         String sql="delete from menu_items where name='"+item+"' and cid="+cid;
         try {
			int rs=stmt.executeUpdate(sql);
			System.out.println("deleted row count : "+rs);
			response.sendRedirect("menu.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
