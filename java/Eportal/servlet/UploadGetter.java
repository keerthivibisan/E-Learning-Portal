package Eportal.servlet;

import java.util.List;
import java.io.File;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import databaseConnect.NewModuleUpload;

@WebServlet("/UploadGetter")
public class UploadGetter extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		
		HttpSession uploadSes = req.getSession(false);
		FileUploadInfoCarrier obj = (FileUploadInfoCarrier) uploadSes.getAttribute("UploaderObj");
		
		try {
			PrintWriter out = res.getWriter();
			
			String Cname = obj.getCname();
			int UID = obj.getUID();
			
			//Retriving uploaded Files
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			
			//Storing uploaded files in List
			List <FileItem> files = sf.parseRequest(req);
			
			for(FileItem file: files)
			{
				file.write(new File("D:\\JAVA-EE-workspace\\E-Portal\\src\\main\\webapp\\Courses\\"+Cname+"("+UID+")"+"//"+file.getName()));
			}
			
			NewModuleUpload dao = new NewModuleUpload();
			boolean flag = dao.CourseRegister(obj);
			
			if(flag)
			{
				res.sendRedirect("UploadSuccess.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
