package leetcode.stack.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	/**
	 * You are given an array of integers nums, 
	 * there is a sliding window of size k which is moving from the very left of the array to the very right. 
	 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
	 * Return the max sliding window.
	 * 
	 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
	 * Output: [3,3,5,5,6,7]
	 * 
	 * Input: nums = [1], k = 1
	 * Output: [1]
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		if (null == nums || 0 == nums.length)
		{
			return new int[0];
		}
		
		int [] result = new int[nums.length - k + 1];
		int ri = 0;

		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < nums.length; i++)
		{
			// remove numbers out of range k
			while(!deque.isEmpty() && deque.peek() < i - k + 1)
			{
				deque.poll();
			}
			// remove smaller numbers in k range as they are useless
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
			{
				deque.pollLast();
			}
			
			// deque contains index of nums
			// result contains value of nums
			deque.offer(i);
			
			if (i >= k - 1)
			{
				result[ri++] = nums[deque.peek()];
			}
		}
		return result;
	}

	// If an element in the deque and it is out of i-(k-1), we discard them. 
	// We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

       // Now only those elements within [i-(k-1),i] are in the deque. 
       // We then discard elements smaller than a[i] from the tail. 
       // This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

      // As a result elements in the deque are ordered in both sequence in array and their value. 
      // At each step the head of the deque is the max element in [i-(k-1),i]
}
