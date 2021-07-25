package leetcode.sliding_window.maximum_length_of_repeated_subarray;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/25 14:26
 */
public class Solution {

    /**
     * Given two integer arrays nums1 and nums2,
     * return the maximum length of a subarray that appears in both arrays.
     *
     * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * Output: 3
     * Explanation: The repeated subarray with maximum length is [3,2,1].
     *
     * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
     * Output: 5
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2)
    {
        // bottom - up DP
//        int ans = 0;
//        int[][] memo = new int[nums1.length + 1][ nums2.length + 1];
//        for(int i=nums1.length - 1; i>=0; --i)
//        {
//            for(int j= nums2.length - 1; j>=0; --j)
//            {
//                if(nums1[i] == nums2[j])
//                {
//                    memo[i][j] = memo[i+1][j+1] + 1;
//                    if(ans < memo[i][j])
//                        ans = memo[i][j];
//                }
//            }
//        }
//        return ans;

        // The initial position and the directions in which we slide.
        // One step means shifting the top array by one position (index) to the right,
        // or the the bottom array by one position (index) to the left:
        //          [1,2,3,2,1]   -->
        //           <--    [3,2,1,4,7]

        //          [1,2,3,2,1]
        //                [3,2,1,4,7]

        //          [1,2,3,2,1]      -->
        //     <--      [3,2,1,4,7]

        //  and so on

        int result = 0;
        for(int i=0; i<nums1.length + nums2.length - 1; ++i)
        {
            int num1Start = Math.max(0,nums1.length -1 -i);
            int num2Start = Math.max(0,i - (nums1.length - 1));
            int numConsecutiveMatches = 0;
            for(int num1Idx = num1Start, num2Idx = num2Start; num1Idx < nums1.length && num2Idx < nums2.length; ++num1Idx, ++ num2Idx)
            {
                numConsecutiveMatches = nums1[num1Idx] == nums2[num2Idx] ? numConsecutiveMatches + 1 : 0;
                result = Math.max(result, numConsecutiveMatches);
            }
        }
        return result;
    }
}
