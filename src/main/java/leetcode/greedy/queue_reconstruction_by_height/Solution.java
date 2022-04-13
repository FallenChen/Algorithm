package leetcode.greedy.queue_reconstruction_by_height;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	
	public int[][] reconstructQueue(int[][] people) 
	{
		// 身高降序排列，身高相同k小的站前面
		Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		
		LinkedList<int[]> que = new LinkedList<>();
		
		for(int[] p: people)
		{
			que.add(p[1], p);
		}
		return que.toArray(new int[people.length][]);
	}

}
