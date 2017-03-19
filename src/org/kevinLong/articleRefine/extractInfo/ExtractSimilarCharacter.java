package org.kevinLong.articleRefine.extractInfo;

import java.util.ArrayList;

import org.kevinLong.articleRefine.util.*;

public class ExtractSimilarCharacter {

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
			scmResult=ReadFileUtil.regexMatchWithAL(matchChar,content);
			mutilScmResult.add(scmResult);
		}
		return mutilScmResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
