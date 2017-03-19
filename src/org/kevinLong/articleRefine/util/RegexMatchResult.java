package org.kevinLong.articleRefine.util;

public class RegexMatchResult 
{
	public int baseLine=0;
	public int start=-1;
	public int end=-1;
	public String matchedStr="null";
	
	public boolean hitEnd=false;
	public boolean hitStart=false;
	
	public int getBaseLine() {
		return baseLine;
	}
	public void setBaseLine(int baseLine) {
		this.baseLine = baseLine;
	}
	
	public int getStart() {
		return baseLine+start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return baseLine+end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getMatchedStr() {
		return matchedStr;
	}
	public void setMatchedStr(String matchedStr) {
		this.matchedStr = matchedStr;
	}
	 
	public boolean isHitEnd() {
		return hitEnd;
	}
	public void setHitEnd(boolean hitEnd) {
		this.hitEnd = hitEnd;
	}
	public boolean isHitStart() {
		return hitStart;
	}
	public void setHitStart(boolean hitStart) {
		this.hitStart = hitStart;
	}

	
	@Override
	public String toString() {
		return "RegexMatchResult [start=" + start + ", end=" + end
				+ ", matchedStr=" + matchedStr + ", hitEnd=" + hitEnd
				+ ", hitStart=" + hitStart + "]";
	}


}
