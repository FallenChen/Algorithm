package leetcode.backtracking.combinatios;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
	 * You may return the answer in any order.
	 * 
	 * Input: n = 4, k = 2
	 * Output:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
	 * 
	 * Input: n = 1, k = 1
	 * Output: [[1]]
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) 
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(result,new ArrayList<Integer>(),n,k,1);
		return result;
	}

	private void combine(List<List<Integer>> result, ArrayList<Integer> arrayList, int n, int k, int start) 
	{
		// if(k == arrayList.size())
		// {
		// 	result.add(new ArrayList<Integer>(arrayList));
		// 	return;
		// }

		// for(int i=start; i<=n; i++)
		// {
		// 	arrayList.add(i);
		// 	combine(result,arrayList,n,k,i+1);
		// 	// when size = k+1 then contine ,so  we need to remove the last element
		// 	arrayList.remove(arrayList.size()-1);
		// }

		if(k==0) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		}
		for(int i=start;i<=n-k + 1;i++) {
			arrayList.add(i);
			combine(result, arrayList, n, k-1, i+1);
			arrayList.remove(arrayList.size()-1);
		}
	}	
}
