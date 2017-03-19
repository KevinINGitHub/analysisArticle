package org.kevinLong.articleRefine.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {

	/**
	 * @param args
	 */
	
	public static void testRegexMatch()
	{
		String articPath=System.getenv().get("SPT");
		String fileName="红楼梦：第六回.txt";
		
		String resultContent="";
		resultContent=ReadFileUtil.readFromFile(articPath,fileName,"GBK");

		ArrayList resultAL=new ArrayList();
		String pattern = "";
		//user regerx to match the given pattern
		//String pattern = "一";
		//pattern = "(\\D*)(\\d+)(.*)";
        //pattern="士隐";
		pattern = "：“\\S*\\s*。”";
		
		resultAL=simpleRegexMatch(pattern,resultContent);
		
       /* resultContent=resultContent.replaceAll(new String("\\]"), new String(""));
        resultContent=resultContent.replaceAll(new String("\\["), new String(""));
        resultContent= resultContent.replaceAll("\\s","");*/
		
		resultAL=SpliceStrByIndex.spliceStrByRegexMatchRet(resultContent, resultAL);
		
        for(int i=1;i<resultAL.size();i++)
		{
        	RegexMatchResult regexMatchResult=(RegexMatchResult) resultAL.get(i);
			System.out.println("Find "+i);
			System.out.println(regexMatchResult.toString());
		}
	}
	

	public static ArrayList regexMatchWithMutilPattern(String[] patternArray,String content)
	{
		ArrayList regexMatchResultArray = new ArrayList();

		String patternStr=patternArray[0];
		System.out.println("regexMatch with pattern: \n"+patternStr+"\n");
		regexMatchResultArray=simpleRegexMatch(patternStr,content);
		for(int i=1;i<patternArray.length;i++)
		{
			patternStr=patternArray[i];
			System.out.println("regexMatch with pattern: \n"+patternStr+"\n");
			regexMatchResultArray=recurRegexMatchWithIncrement(patternStr,regexMatchResultArray);
		}
		return regexMatchResultArray;
	}
	

	public static ArrayList recurRegexMatchWithIncrement(String pattern,ArrayList regexMatchArray)
	{
		ArrayList regexMatchResultArray = new ArrayList();
		String content="";
		for (Object regexMatchObj : regexMatchArray) {
			RegexMatchResult regexMatchResult = (RegexMatchResult) regexMatchObj;
			content = regexMatchResult.getMatchedStr();
			Pattern r = Pattern.compile(pattern);
			// create matcher object
			Matcher m = r.matcher(content);
			boolean isFind = false;
			while (m.find()) {
				isFind = true;
				RegexMatchResult regexMatchRet = new RegexMatchResult();
				regexMatchRet.setBaseLine(regexMatchResult.getStart());
				regexMatchRet.setStart(m.start());
				regexMatchRet.setEnd(m.end());
				regexMatchRet.setMatchedStr(m.group());
				regexMatchRet.setHitEnd(m.hitEnd());
				if (m.start() == 0) {
					regexMatchRet.setHitStart(true);
				}
				regexMatchResultArray.add(regexMatchRet);
			}
			if (!isFind)
				regexMatchResultArray.add(regexMatchResult);

		}
		return regexMatchResultArray;
	}
	
	
	public static ArrayList simpleRegexMatch(String pattern,String content)
	{
		ArrayList RegexMatchResultArray = new ArrayList();
 
		// create Pattern object
		Pattern r = Pattern.compile(pattern);

		// create matcher object
		Matcher m = r.matcher(content);
		while (m.find()) {
			RegexMatchResult regexMatchRet = new RegexMatchResult();
			regexMatchRet.setStart(m.start());
			regexMatchRet.setEnd(m.end());
			regexMatchRet.setMatchedStr(m.group());
			regexMatchRet.setHitEnd(m.hitEnd());
			if (m.start() == 0) {
				regexMatchRet.setHitStart(true);
			}
			RegexMatchResultArray.add(regexMatchRet);
		}
		return RegexMatchResultArray;
	}
	
	public static void main(String[] args) {
		testRegexMatch();
	}

}
 