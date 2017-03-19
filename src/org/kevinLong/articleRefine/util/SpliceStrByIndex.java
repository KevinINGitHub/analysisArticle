package org.kevinLong.articleRefine.util;

import java.util.ArrayList;

public class SpliceStrByIndex {

	/**
	 * @param args
	 */
	public static ArrayList spliceStrByRegexMatchRet(String content, ArrayList regexMatchRetArray)
	{
		ArrayList spliceRetArray =new ArrayList();
		int firstIndex=0;
		for(int i=0;i<regexMatchRetArray.size();i++)
		{
			RegexMatchResult regexMatchRet = (RegexMatchResult) regexMatchRetArray.get(i);
			RegexMatchResult regexMatchRetTmp =new RegexMatchResult();
			if(firstIndex<regexMatchRet.getStart())
			{
				regexMatchRetTmp.setStart(firstIndex);
				regexMatchRetTmp.setEnd(regexMatchRet.getStart());
				regexMatchRetTmp.setMatchedStr(content.subSequence(firstIndex, regexMatchRet.getStart()).toString());
				if(firstIndex==0)
				{
					regexMatchRetTmp.setHitStart(true);
				}
				spliceRetArray.add(regexMatchRetTmp);
			}
			spliceRetArray.add(regexMatchRet);
			firstIndex=regexMatchRet.getEnd();
		}
		return spliceRetArray;
	}
	
	public static void main(String[] args)
	{
		ReadFileUtil.getTestContents();
	}

}
