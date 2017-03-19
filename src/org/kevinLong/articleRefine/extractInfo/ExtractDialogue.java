package org.kevinLong.articleRefine.extractInfo;

import java.util.*;

import org.apache.commons.lang3.ArrayUtils;
import org.kevinLong.articleRefine.util.*;


public class ExtractDialogue {
	
	public static ArrayList extractDialogueByPartn(String[] contentArray, String pattern)
	{
		ArrayList DialogueArrayNew;
		ArrayList DialogueArray=new ArrayList();
		ArrayList DialogueArrayOld=new ArrayList();
		
		String content="";
		for(int i=0;i<contentArray.length;i++)
		{
			content=contentArray[i];
			DialogueArrayNew=ReadFileUtil.regexMatchWithAL(pattern,content);
			if(DialogueArrayNew.size()==0)
			{
				DialogueArrayNew=new ArrayList(Arrays.asList(contentArray));
			}
			DialogueArray.addAll(DialogueArrayOld);
			DialogueArray.addAll(DialogueArrayNew);
			DialogueArrayOld=(ArrayList) DialogueArray.clone();
		}
		pattern = "：“\\S*\\s*。”";
		return DialogueArray;
	}
	
	
	public static ArrayList extractDialogueByPartnArray(String[] contentArray, String[] patternArray)
	{
		ArrayList DialogueArrayNew;
		ArrayList DialogueArray=new ArrayList();
		ArrayList DialogueArrayOld=new ArrayList();
		
		for(int j=0;j<patternArray.length;j++)
		{
			String patternStr=patternArray[j];
			DialogueArrayNew=extractDialogueByPartn(contentArray, patternStr);
			contentArray=(String[]) DialogueArrayNew.toArray(new String[DialogueArrayNew.size()]);
			/*DialogueArray.addAll((Collection) DialogueArrayOld.clone());
			DialogueArray.addAll((Collection) DialogueArrayNew.clone());
			DialogueArrayOld=(ArrayList) DialogueArray.clone();*/
		}
		return DialogueArray;
	}
	public static String splicePattern(String before,String after)
	{
		String patternTemplate="\\S*\\s*";
		return before+patternTemplate+after;
	}
	
	public static String[][] shufflePatternArray(String[] patternArray)
	{
		String[][] patternDoubleArray=new String[patternArray.length][];
		for(int i=0;i<patternArray.length;i++)
		{
			String[] tempArray=patternArray.clone();
			String tmp=tempArray[i];
			tempArray[i]=tempArray[0];
			tempArray[0]=tmp;
			patternDoubleArray[i]=tempArray;
		}
		return patternDoubleArray;
	}

	
	static void testExtractDialogue(String contents)
	{
		String[] punctArray={splicePattern("：“","”")
				,splicePattern("：“","\"")
				,splicePattern("：“","”")
				,splicePattern("：“","。”")
				,splicePattern("：“","？\"")
				,splicePattern("：“","。”")
				};
		
		String[][] patternDoubleArray=shufflePatternArray(punctArray);
		for(int i=0;i<patternDoubleArray.length;i++)
		{
			String[] contentsArray={contents};
			String[] punctArrayTmp=patternDoubleArray[i];
			
			System.out.println("First regexMatch with patternArray:"+punctArrayTmp.toString());
			ArrayList resultArray=new ArrayList();
			resultArray=RegexMatch.regexMatchWithMutilPattern(punctArrayTmp,contents);
			
			for(Object s : resultArray)
				System.out.println("resultArray:"+s.toString());
		}
		
		//resultArray=extractDialogueByPartnArray(contentsArray,punctArray);
	}
	 
	
	public static void main(String[] args) 
	{
		String articPath=System.getenv().get("SPT");
		String fileName="红楼梦：第六回.txt";
		
		String resultContent="";
		resultContent=ReadFileUtil.readFromFile(articPath,fileName,"GBK");
		
		testExtractDialogue(resultContent);
	}

}
