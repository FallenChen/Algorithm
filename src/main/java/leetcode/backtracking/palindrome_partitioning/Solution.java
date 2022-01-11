package leetcode.backtracking.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution 
{
	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome. 
	 * Return all possible palindrome partitioning of s.
	 * A palindrome string is a string that reads the same backward as forward.
	 * 
	 * Input: s = "aab"
	 * Output: [["a","a","b"],["aa","b"]]
	 * 
	 * Input: s = "a"
	 * Output: [["a"]]
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) 
	{
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;
		
		partitionHelper(s, 0, new ArrayList<>(), result);
		return result;
	}

	private void partitionHelper(String s, int i, List<String> currenList, List<List<String>> result) 
	{
		// start index is the end of the string
		if (i == s.length())
		{
			result.add(new ArrayList<>(currenList));
			return;
		}
		
		for (int j = i; j < s.length(); j++)
		{
			String subString = s.substring(i, j + 1);
			if (isPalindrome(subString))
			{
				currenList.add(subString);
				partitionHelper(s, j + 1, currenList, result);
				currenList.remove(currenList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String subString) {
		int i = 0;
		int j = subString.length() - 1;
		while (i < j)
		{
			if (subString.charAt(i) != subString.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}


}
