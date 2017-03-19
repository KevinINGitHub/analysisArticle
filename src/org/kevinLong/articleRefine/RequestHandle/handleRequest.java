package org.kevinLong.articleRefine.RequestHandle;

import java.io.IOException;


import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kevinLong.articleRefine.util.*;

 
/**
 * Servlet implementation class handleRequest
 */
@WebServlet("/handleRequest")
public class handleRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	static String strTargetEncoding="GBK";
	static String strDefaultEncoding="GBK";

       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName="";
		ArrayList filterResult=null;
		String contents="";
		String strFilterResult="";
		String partern="";
		
		request.setCharacterEncoding(strTargetEncoding);

		String articPath=request.getParameter("path");
		//fileName=request.getParameter("fileName");
		//partern=request.getParameter("partern");
		
		fileName=new String(request.getParameter("fileName").getBytes("8859_1"), "GBK");
		partern= new String(request.getParameter("partern").getBytes("8859_1"), "GBK");
		
		contents = ReadFileUtil.readFromFile(articPath, fileName,strTargetEncoding);
		
		System.out.println("ReadFromFile contents :"+ contents);
		
		if (partern!="")
		{
			System.out.println("Filter with partern:"+partern);
			filterResult=ReadFileUtil.regexMatchWithAL(partern, contents);
			strFilterResult=filterResult.toString();
		}
		else
		{
			strFilterResult="<font size=\"3\" color=\"red\">partern is null</font>";
		}
		request.setAttribute("contents", contents);
		request.setAttribute("filterResult", strFilterResult);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("handleDoc.jsp");
		dispatcher.forward(request, response);

		//response.sendRedirect("handleDoc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*String articPath="C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project\\TXT\\";
		String fileName="TestDoc.txt";*/
		
		String articPath=System.getenv().get("SPT");
		String fileName="红楼梦：第二回.txt";
		
		String resultContent="";
		String resultContentRBB="";

		resultContent=ReadFileUtil.readFromFile(articPath,fileName,"GBK");

/*		//user regerx to match the given pattern
		String pattern = "一";
		String pattern1 = "一";
		ArrayList resultAL=new ArrayList();
		
		//resultContent = "This order was placed for QT3000! OK?";
        pattern = "(\\D*)(\\d+)(.*)";
        pattern1="士隐";
        
		resultAL=regexMatchWithAL(pattern1,resultContent);
		System.out.print("resultContent:\n\n"+resultContent);
        
        resultContent=resultContent.replaceAll(new String("\\]"), new String(""));
        resultContent=resultContent.replaceAll(new String("\\["), new String(""));

        resultContent= resultContent.replaceAll("\\s","");
		resultAL=similarCharacterMatch(resultContent,2);
		System.out.print("resultAL:\n\n"+resultAL.toString());
		
		
		System.out.print("resultAL:\n\n"+resultAL.toString());

		for(int i=1;i<resultAL.size();i++)
		{
			System.out.println("Find "+i);

			System.out.println(resultAL.get(i));
		}*/
		
		System.out.print("resultContent:\n\n"+resultContent);
	}


}
