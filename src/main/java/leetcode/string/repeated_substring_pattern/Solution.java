package leetcode.string.repeated_substring_pattern;

public class Solution {

	// kmp
	public boolean repeatedSubstringPattern(String s) {
		
		if(s == null || s.length() == 0)
		{
			return false;
		}
		int next[] = new int[s.length()];
		getNext(next, s);
		int len = s.length();
		if(next[len - 1] != 0 && len % (len - (next[len - 1])) == 0)
		{
			return true;
		}
		return false;
	}

	private void getNext(int[] next, String s)
	{
		next[0] = 0;
		int j=0;
		char[] str = s.toCharArray();
		for(int i=1; i<s.length();i++)
		{
			while(j>0 && str[i]!=str[j])
			{
				j = next[j-1];
			}
			if(str[i]==str[j])
			{
				j++;
			}
			next[i] = j;
		}

	}
}
