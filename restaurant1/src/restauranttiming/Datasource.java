package restauranttiming;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;



public class Datasource extends HttpServlet {
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		 	DB_Connection db=new DB_Connection();
		 	Statement stmt= db.getstatement();
		 	PrintWriter out=response.getWriter();
		 	List<Itemmodel> iml=new ArrayList<Itemmodel>();
		 	int cuisineid;
		 	Itemmodel im=new Itemmodel();
		 	HttpSession session=request.getSession();
		 	cuisineid=Integer.parseInt(session.getAttribute("cuisineid").toString());
		 	String sql="select food_group,name,image,Description,price from menu_items where cid="+cuisineid;
		 	try {
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					im.setFoodgroup(rs.getString(1));
					im.setName(rs.getString(2));
					im.setLocation(rs.getString(3));
					im.setDescription(rs.getString(4));
					im.setPrice(rs.getInt(5));
					System.out.println(im);
					iml.add(im);
				}
				session.setAttribute("datalist", new Gson().toJson(iml));
				System.out.println(session.getAttribute("datalist"));
				
				out.write(new Gson().toJson(iml).toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
	 }

}
