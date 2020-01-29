package restauranttiming;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public class browse extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  /*  String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    System.out.println(description);
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    System.out.println(filePart);
	    String fileName = Paths.get(getSubmittedFileName(filePart)).getFileName().toString();
	    System.out.println(fileName);
	    InputStream fileContent = filePart.getInputStream();
	    
	    // ... (do your job here)
*/	
		  try {
			  
			  Part uploadedFile = request.getPart("uploadedFile"); // Retrieves <input type="file" name="uploadedFile">
		        //InputStream content = uploadedFile.get;
		        
		        
		        List<FileItem> items =new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request)); 
		        	System.out.println(items);	
		        	System.out.println(items.get(0));
		        for (FileItem item : items) {
		        	
		        	//System.out.println(item.getString());
		            if (item.isFormField()) {
		                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
		                String fieldName = item.getFieldName();
		                String fieldValue = item.getString();
		                System.out.println(fieldName);
		                System.out.println(fieldValue);
		                // ... (do your job here)
		            } else {
		                // Process form file field (input type="file").
		                String fieldName = item.getFieldName();
		                String fileName = FilenameUtils.getName(item.getName());
		                System.out.println(fieldName);
		                System.out.println(fileName);
		                SimpleDateFormat sdf = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
		                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		                
			        	 File Dest =new File("D:\\f\\test"+sdf.format(timestamp)+".jpg");
			        	try {
							item.write(Dest);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                
		                // ... (do your job here)
		            }
		            
		        }
		    } catch (FileUploadException e) {
		        throw new ServletException("Cannot parse multipart request.", e);
		    }	
	}
	
	

}
