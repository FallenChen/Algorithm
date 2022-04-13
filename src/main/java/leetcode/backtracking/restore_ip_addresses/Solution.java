package leetcode.backtracking.restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	/**
	 * A valid IP address consists of exactly four integers separated by single dots. 
	 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
	 * 
	 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", 
	 * "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
	 * 
	 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s.
	 *  You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
	 * 
	 * Input: s = "25525511135"
	 * Output: ["255.255.11.135","255.255.111.35"]
	 * 
	 * Input: s = "0000"
	 * Output: ["0.0.0.0"]
	 * 
	 * Input: s = "101023"
	 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s)
	{
		List<String> result = new ArrayList<String>();

		if (s == null || s.length() < 4 || s.length() > 12)
		{
			return result;
		}

		backtrack(s, 0, 0, result);
		return result;
	}

	/**
	 * 
	 * @param s
	 * @param startIndex
	 * @param pointNum ","
	 * @param result
	 */
	private void backtrack(String s, int startIndex, int pointNum, List<String> result) 
	{
		if(3 == pointNum)
		{
			if(isValid(s,startIndex,s.length() - 1))
			{
				result.add(s);
			}
			return;
		}

		for(int i = startIndex; i<s.length(); i++)
		{
			if(isValid(s,startIndex,i))
			{
				s = s.substring(0, i + 1) + "." + s.substring(i + 1);
				pointNum++;
				backtrack(s, i + 2, pointNum, result);
				pointNum--;
				s = s.substring(0, i + 1) + s.substring(i + 2);
			}
			else
			{
				break;
			}
		}

	}

	private boolean isValid(String s, int start, int end)
	{
		if(start > end)
		{
			return false;
		}

		if('0' == s.charAt(start) && start != end)
		{
			return false;
		}

		int num = 0;

		for(int i= start; i <= end; i++)
		{
			if('9' < s.charAt(i) || '0' > s.charAt(i))
			{
				return false;
			}
			num = num * 10 + (s.charAt(i) - '0');
			if(255 <  num)
			{
				return false;
			}
		}
		return true;
	}

	
}
