package leetcode.greedy.lemonade_change;



public class Solution {
	
	public boolean lemonade_change(int[] bills)
	{
		int five = 0, ten = 0;

		for (int i = 0; i < bills.length; i++)
		{
			if(bills[i] == 5)
			{
				five++;
			}
			else if (bills[i] == 10)
			{
				five--;
				ten++;
			}
			else if (ten > 0)
			{
				ten--;
				five--;
			}
			else
			{
				five -= 3;
			}
			if(five < 0)
			{
				return false;
			}
		}

		return true;
	}
}
