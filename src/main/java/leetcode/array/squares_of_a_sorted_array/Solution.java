package leetcode.array.squares_of_a_sorted_array;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/9 20:24
 */
public class Solution {

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {

        int k = nums.length - 1;
        int[] result = new int[nums.length];
        // i<=j 最后要处理两个元素
        for(int i=0,j = nums.length-1; i<=j;)
        {
            if(nums[i]*nums[i] < nums[j]*nums[j])
            {
                result[k--] = nums[j]*nums[j];
                j--;
            }
            else
            {
                result[k--] = nums[i]*nums[i];
                i++;
            }
        }
        return result;
    }
}
