package leetcode.array.trapping_rain_water;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/28 20:18
 */
public class Solution {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case, 6 units of rain water (blue section) are being trapped.
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // Brute force
//        int ans = 0;
//        int size = height.length;
//        for(int i=1;i<size-1;i++)
//        {
//            int max_left = 0;
//            int max_right = 0;
//            for(int j=i; j>=0; j--)
//            {
//                max_left = Math.max(max_left,height[j]);
//            }
//            for(int j=i; j<size;j++)
//            {
//                max_right = Math.max(max_right,height[j]);
//            }
//            ans += Math.min(max_left,max_right) - height[i];
//        }
//        return ans;

        // two pointer
        if(height.length == 0)
        {
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right)
        {
            if(height[left] > leftMax)
            {
                leftMax = height[left];
            }
            if(height[right] > rightMax)
            {
                rightMax = height[right];
            }
            if(leftMax < rightMax)
            {
                ans += Math.max(0,leftMax - height[left]);
                left++;
            }else
            {
                ans += Math.max(0,rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}
