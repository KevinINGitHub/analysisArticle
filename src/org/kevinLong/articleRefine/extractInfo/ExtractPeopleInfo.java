package org.kevinLong.articleRefine.extractInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.kevinLong.articleRefine.util.*;


public class ExtractPeopleInfo {

	static String strTargetEncoding="GBK";
	static String strDefaultEncoding="GBK";
	 
	static String[]  divideClausesByStr(String[] contents,String strPunct)
	{
		String[] clauseArrayNew;
		String[] clauseArray={};
		String[] clauseArrayOld={};
		
		for (int i=0;i<contents.length;i++)
		{
			String splitStr=contents[i];
			clauseArrayNew=splitStr.split(strPunct);
			if(clauseArrayNew.length==0)
			{
				clauseArrayNew=new String[]{splitStr};
			}
			clauseArray=ArrayUtils.addAll(clauseArrayOld,clauseArrayNew);
			clauseArrayOld=clauseArray.clone();
		}
		return clauseArray;
	}
	
	static String[]  divideClausesByStrArray(String[] contents,String[] punctArray)
	{
		String[] clauseArray={};
		
		for(int j=0;j<punctArray.length;j++)
		{
			String punctStr=punctArray[j];
			clauseArray=divideClausesByStr(contents, punctStr);
			contents=clauseArray.clone();
		}
		return clauseArray;
	}
	
	static Map<String,String> divideDialogue(String[] contents,String[] punctArray)
	{
		Map<String,String> dialogueMap=new HashMap();
		
		 
		return dialogueMap;
	}
	
	static void testFdivideDialogue(String  contents)
	{
		Map<String,String> dialogueMap=new HashMap();
		
		 
	}
	
	static ArrayList filterPeopleName(String contents)
	{
		ArrayList peopleList=new ArrayList();
		ArrayList clausesList=new ArrayList();

		//Rule 1. divide clauses
		String[] punctArray={"，","：","“","．","。",":"};
		for(String s : punctArray)
		System.out.println(s);
		
		
		//Rule 2.located people
		//some words before
		//other words after
		//surname 
 
		ArrayList<String> beforeList=new ArrayList<String>(Arrays.asList("却说",
				"听见",
				"将"));
		
		ArrayList<String> afterList=new ArrayList<String>(Arrays.asList("道：",
				"便","给","忙迎上来","笑道：","说道："
				));
		
		ArrayList<String> surnameList=new ArrayList<String>(Arrays.asList("贾","周",
				"刘","李","王","马","龙",
				"宋"));

		
		for(String s : beforeList)
			System.out.println("beforeList:"+s);
		
		for(String s : afterList)
			System.out.println("afterList:"+s);
		
		return peopleList;
	}
	static void testForDivideClauses(String contents)
	{
		String[] punctArray={"，","：","“","．","。",":","．","：“","。”","？","\"","”","："};
		String[] contentsArray={contents};
		String[] resultArray=null;

		resultArray=divideClausesByStrArray(contentsArray,punctArray);
		
		for(String s : resultArray)
			System.out.println("resultArray:"+s);
	}
	
	public static void main(String[] args) {
		
		String contents="";
		String articPath=System.getenv().get("SPT");
	//	String fileName="红楼梦：第一回.txt";
		String fileName="splitFile.txt";
		
		contents = ReadFileUtil.readFromFile(articPath, fileName,strTargetEncoding);
		System.out.println("ReadFromFile contents :"+ contents);
		
		//test For Divide Clauses
		testForDivideClauses(contents);
		 
		
		filterPeopleName("");
	}

}
