package leetcode.greedy.container_with_most_water;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/19 20:16
 */
public class Solution {

    /**
     * Given n non-negative integers a1, a2, ..., an ,
     * where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     *
     * Notice that you may not slant the container.
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Input: height = [1,1]
     * Output: 1
     *
     * Input: height = [4,3,2,1,4]
     * Output: 16
     *
     * Input: height = [1,2,1]
     * Output: 2
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height)
    {
        int l =0, r =height.length - 1;
        int ans = 0;
        while (l < r)
        {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans,area);
            if(height[l] <= height[r])
            {
                ++l;
            }
            else
            {
                --r;
            }
        }
        return ans;
    }
}
