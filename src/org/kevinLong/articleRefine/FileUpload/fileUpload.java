package org.kevinLong.articleRefine.FileUpload;

 import  java.io.*;
 import java.util.*;
 import javax.servlet.* ;
 import  javax.servlet.http.* ;
 import  org.apache.commons.fileupload.* ;
 import  org.apache.commons.fileupload.FileItemFactory.*;
 import org.apache.commons.fileupload.disk.*; 
 import org.apache.commons.fileupload.servlet.*; 
 import org.apache.commons.io.output.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileUpload
 */
@WebServlet("/fileUpload")
public class fileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		File file ;
		File file1 ;
		   int maxFileSize = 5000 * 1024;
		   int maxMemSize = 5000 * 1024;
		   String filePath = "C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project\\";
		   String filePath1 = "C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project";

		   // Verify the content type
		   String contentType = request.getContentType();
		   if ((contentType.indexOf("multipart/form-data") >= 0)) {

		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // maximum size that will be stored in memory
		      factory.setSizeThreshold(maxMemSize);
		      // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // Create a new file upload handler
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // maximum file size to be uploaded.
		      upload.setSizeMax( maxFileSize );
		      try{ 
		         // Parse the request to get file items.
		         List fileItems = upload.parseRequest(request);
		         // Process the uploaded file items
		         Iterator i = fileItems.iterator();
		         System.out.println("File upload");
		         while ( i.hasNext () ) 
		         {
		            FileItem fi = (FileItem)i.next();
		            if ( !fi.isFormField () )	
		            {
		            // Get the uploaded file parameters
		            String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            
			        System.out.println("File contents:"+fi.getString());

		            
		            // Write the file
		            if( fileName.lastIndexOf("\\") >= 0 ){
		            file = new File( filePath + 
		            fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		            file = new File( filePath + 
		            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		            
		            /*if( fileName.lastIndexOf("\\") >= 0 ){
			            file1 = new File( filePath1 + 
			            fileName.substring( fileName.lastIndexOf("\\"))) ;
			            }else{
			            file1 = new File( filePath1 + 
			            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			            }
		            fi.write( file1) ;*/
		            
		            }
		         }
		         System.out.println("Finished file upload");
		      }catch(Exception ex) {
		         System.out.println(ex);
		      }
		   }else{
			   System.out.println("no file upload");
		   }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
