package leetcode.string.reverse_string_ii;

public class Solution {
	
	public String reverseStr(String s, int k) {

		char[] chars = s.toCharArray();
		int n = chars.length;
		int i = 0;
		while(i < n)
		{
			int j = Math.min(i+k-1, n-1);
			swap(chars,i,j);
			i += 2*k;
		}
		return String.valueOf(chars);
	}

	private void swap(char[] arr, int i, int j) {
		while(i < j)
		{
			char temp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = temp;
		}
	}
}
