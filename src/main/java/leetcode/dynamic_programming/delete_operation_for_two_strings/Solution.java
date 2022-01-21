package leetcode.dynamic_programming.delete_operation_for_two_strings;

public class Solution {
	
	public int minDistance(String word1, String word2) 
	{
		// find the longest common subsequence
		
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for(int i=0; i<=word1.length(); i++)
		{
			for(int j=0; j<=word2.length(); j++)
			{
				if(0 == i || 0 ==j)
				{
					dp[i][j] = 0;
				}
				else 
				dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ?
				dp[i-1][j-1] + 1 :
				Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		// not belong to longest common subsequence
		int val = dp[word1.length()][word2.length()];
		return word1.length() - val + word2.length() - val;
	}
}
