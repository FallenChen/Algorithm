package leetcode.greedy.gas_station;

public class Solution {
	
	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		// 1
		// for(int i = 0; i < cost.length ; i++)
		// {
		// 	// 记录每个加油站的剩余油量
		// 	int rest = gas[i] - cost[i];
		// 	int index = (i + 1) % cost.length;
		// 	while(rest >= 0)
		// 	{
		// 		rest += gas[index] - cost[index];
		// 		index = (index + 1) % cost.length;
		// 		if(index == i)
		// 		{
		// 			return i;
		// 		}
		// 	}
		// }
		// return -1;

		// 2
		int curSum = 0;
		int totalSum = 0;
		int index = 0;
		for(int i=0; i<gas.length; i++)
		{
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if(curSum < 0)
			{
				index = i + 1;
				curSum = 0;
			}
		}
		if(totalSum < 0)
		{
			return -1;
		}
		return index;
	}
}
