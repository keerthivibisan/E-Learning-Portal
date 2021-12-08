package Eportal.servlet;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/UpdateWriter")
public class TUpdateWriter extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession ExistingUpdate = req.getSession(false);
		
		//POJO Object
		FileUploadInfoCarrier carry = (FileUploadInfoCarrier) ExistingUpdate.getAttribute("ExistingUploadOBJ");
		
		String path = carry.getFpath();
		
		try
		{
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			
			List <FileItem> files = sf.parseRequest(req);
			
			for(FileItem f: files)
			{
				f.write(new File(path+"/"+f.getName()));
			}
			
			res.sendRedirect("UploadSuccess.jsp");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
