package leetcode.two_pointers.find_the_duplicate_number;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/6 18:51
 */
public class Solution {

    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     *
     * Input: nums = [1,1]
     * Output: 1
     *
     * Input: nums = [1,1,2]
     * Output: 1
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums)
    {
        // Find the intersection point of the two runners.
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        // Find the "entrance" to the cycle.
        slow = 0;
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};

        int duplicate = findDuplicate(nums);

        System.out.println(duplicate);;
    }
}
