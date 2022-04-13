package leetcode.bit_manipulation.single_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/8 20:02
 */
public class Solution {

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one.
     * Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     * Input: nums = [1]
     * Output: 1
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums)
    {
//        List<Integer> no_duplicate_list = new ArrayList<>();
//
//        for(int i : nums)
//        {
//            if(!no_duplicate_list.contains(i))
//            {
//                no_duplicate_list.add(i);
//            }else
//            {
//                no_duplicate_list.remove(new Integer(i));
//            }
//        }
//
//        return no_duplicate_list.get(0);

        // This XOR operation works because it's like XORing all the numbers by itself.
        // So if the array is {2,1,4,5,2,4,1} then it will be like we are performing this operation
        // ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.
        int a = 0;
        for(int i: nums)
        {
            a ^= i;
        }
        return a;
    }
}
