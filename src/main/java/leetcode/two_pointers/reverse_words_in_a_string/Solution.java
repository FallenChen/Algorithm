package leetcode.two_pointers.reverse_words_in_a_string;

public class Solution {
	
	/**
	 * Given an input string s, reverse the order of the words.
	 * A word is defined as a sequence of non-space characters. 
	 * The words in s will be separated by at least one space.
	 * Return a string of the words in reverse order concatenated by a single space.
	 * Note that s may contain leading or trailing spaces or multiple spaces between two words. 
	 * The returned string should only have a single space separating the words. 
	 * Do not include any extra spaces.
	 * 
	 * Input: s = "the sky is blue"
	 * Output: "blue is sky the"
	 * 
	 * Input: s = "  hello world  "
	 * Output: "world hello"
	 * Explanation: Your reversed string should not contain leading or trailing spaces.
	 * 
	 * Input: s = "a good   example"
	 * Output: "example good a"
	 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) 
	{
		if(null == s || s.length() == 0)
		{
			return s;
		}

		char[] a = s.toCharArray();
		int n = a.length;

		reverse(a, 0, n - 1);

		reverseWords(a,n);

		return cleanSpaces(a,n);
	}

	private void reverse(char[] a, int i, int j) 
	{
		while(i < j)
		{
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}

	void reverseWords(char[] a, int n) {
		int i = 0, j = 0;
		  
		while (i < n) {
		  while (i < j || i < n && a[i] == ' ') i++; // skip spaces
		  while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
		  reverse(a, i, j - 1);                      // reverse the word
		}
	}
	      
	      // trim leading, trailing and multiple spaces
	String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;
		  
		while (j < n) {
		  while (j < n && a[j] == ' ') j++;             // skip spaces
		  while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
		  while (j < n && a[j] == ' ') j++;             // skip spaces
		  if (j < n) a[i++] = ' ';                      // keep only one space
		}
	      
		return new String(a).substring(0, i);
	}

	
}
