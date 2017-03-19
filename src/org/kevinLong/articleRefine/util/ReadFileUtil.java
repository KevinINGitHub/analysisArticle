package org.kevinLong.articleRefine.util;
import java.io.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

import java.nio.charset.Charset;

public class ReadFileUtil{
 
	static String strTargetEncoding="GBK";
	static String strDefaultEncoding="GBK";

	public static String readFromFile(String articPath, String fileName)
	{
		return readFromFile(articPath, fileName, strDefaultEncoding);
	}
	 
	public static String readFromFile(String articPath, String fileName ,String strEncoding)
	{
		String resultContent="";
		File file = new File(articPath+fileName);
	    char[] tempchars = new char[50];
	    int charread = 0;
	    
	    InputStream is;
		Reader reader = null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(file),strEncoding);
			while((charread = reader.read(tempchars)) != -1)
			{
				 if ((charread == tempchars.length)
	                        && (tempchars[tempchars.length - 1] != '\r'))
				 {
					 	//System.out.print("Print the tempchars contents!\n");
	                    //System.out.print(new String(tempchars));
	             }
				 resultContent+=new String(tempchars);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*//Covert result to special character set. default is gbk
		try {
			resultContent = new String(resultContent.getBytes(strEncoding),strTargetEncoding);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return resultContent;
	}
	
	public static String readFromFileByBytes(String articPath, String fileName)
	{
        File file = new File(articPath+fileName);
        FileInputStream fis ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
        	  fis = new FileInputStream(file);
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileToBytesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = bos.toByteArray();
        String resultContent="";
		try {
			resultContent = new String(bytes,strTargetEncoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.print("contents:"+resultContent);
        return resultContent;
	}
	
	public static ArrayList regexMatchWithAL(String pattern,String content)
	{
		  ArrayList alResult=new ArrayList();
		  String result="";
		  
	      // create Pattern object
	      Pattern r = Pattern.compile(pattern);
	 
	      // create matcher object
	      Matcher m = r.matcher(content);
    	  System.out.println("\n");
    	  while(m.find( ))
    	  {
    		  System.out.print("Start index: " + m.start());
    	        System.out.print(" End index: " + m.end());
    	        System.out.println(" Found: " + m.group());
    		  alResult.add(m.group());
    	  }
		return alResult;
	}
	
	/*
	 * This function to statistics the frequency of the continuous characters which given number.
	 * Such as:
   	 * 		Start index: 2657 End index: 2659 Found: 云：Start
	 * when give the continuous number is 5. then with function similarCharacterMatch,
	 * we will find those string listed below:
  	 *		 Start---2 , index--2
	 * 
	 */
	public static ArrayList similarCharacterMatch(String content,int charNum)
	{
		ArrayList mutilScmResult=new ArrayList();
		
        int indexNum=500;
		ArrayList scmResult=new ArrayList();
		for(int i=1;i<indexNum;i++)
		{
			int beginIndex=i;
			String matchChar=(String) content.substring(beginIndex, beginIndex+charNum);
			System.out.println("matchChar"+matchChar);
			scmResult=regexMatchWithAL(matchChar,content);
			mutilScmResult.add(scmResult);
		}
		return mutilScmResult;
	}
	
	static void testForDivideSimilarCharacter(String content)
	{
		ArrayList resultAL=null;
		resultAL=similarCharacterMatch(content,2);
		System.out.print("resultAL:\n\n"+resultAL.toString());

		for(int i=1;i<resultAL.size();i++)
		{
			System.out.println("Find "+i);

			System.out.println(resultAL.get(i));
		}
	}
	
	public static String getTestContents()
	{
		String articPath=System.getenv().get("SPT");
		String fileName="红楼梦：第六回.txt";
		String contents=readFromFile(articPath,fileName,"GBK");
		
		return contents;
	}
	
	
	public static void main(String[] args)
	{
		/*String articPath="C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project\\TXT\\";
		String fileName="TestDoc.txt";*/
		
/*		String articPath=System.getenv().get("SPT");
		String fileName="红楼梦：第六回.txt";
		
		String resultContent="";
		resultContent=readFromFile(articPath,fileName,"GBK");

		ArrayList resultAL=new ArrayList();
		String pattern = "";
		//user regerx to match the given pattern
		//String pattern = "一";
		//pattern = "(\\D*)(\\d+)(.*)";
        //pattern="士隐";
		pattern = "：“\\S*\\s*。”";
		
		resultAL=regexMatchWithAL(pattern,resultContent);
        
        resultContent=resultContent.replaceAll(new String("\\]"), new String(""));
        resultContent=resultContent.replaceAll(new String("\\["), new String(""));
        resultContent= resultContent.replaceAll("\\s","");
        
        for(int i=1;i<resultAL.size();i++)
		{
			System.out.println("Find "+i);

			System.out.println(resultAL.get(i));
		}*/
	
        //testForDivideSimilarCharacter
        //testForDivideSimilarCharacter(resultContent);
		
		//System.out.print("resultContent:\n\n"+resultContent);
        
        System.out.print(getTestContents());
	}
	

}
