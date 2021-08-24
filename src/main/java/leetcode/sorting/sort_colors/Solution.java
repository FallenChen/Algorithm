package leetcode.sorting.sort_colors;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/30 20:48
 */
public class Solution {

    /**
     * Given an array nums with n objects colored red, white, or blue,
     * sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue.
     *
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     *
     * You must solve this problem without using the library's sort function.
     *
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     *
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     *
     * Input: nums = [0]
     * Output: [0]
     *
     * Input: nums = [1]
     * Output: [1]
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        int low = 0;
        int high = nums.length - 1;
        for (int i=low;i<=high;)
        {
            if(nums[i] == 0)
            {
                // swap nums[i] and nums[low] and
                // i,low both ++
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                i++;
                low++;
            }
            else if (nums[i] == 2)
            {
                // swap nums[i] and nums[high] and high--;
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
            else
            {
                i++;
            }
        }
    }
}
