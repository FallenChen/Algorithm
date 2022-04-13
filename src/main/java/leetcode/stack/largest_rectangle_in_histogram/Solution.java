package leetcode.stack.largest_rectangle_in_histogram;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/5 13:40
 */
public class Solution {

    /**
     * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
     * return the area of the largest rectangle in the histogram.
     *
     * Input: heights = [2,1,5,6,2,3]
     * Output: 10
     * Explanation: The above is a histogram where width of each bar is 1.
     * The largest rectangle is shown in the red area, which has an area = 10 units.
     *
     * Input: heights = [2,4]
     * Output: 4
     *
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        // Brute force
        // 依次遍历柱形的高度，对于每个高度分别向两边扩散
//        int len = heights.length;
//
//        if(len == 0)
//        {
//            return 0;
//        }
//
//        int res = 0;
//        for(int i=0; i<len; i++)
//        {
//            // 找左边最后一个大于等于heights[i]的下标
//            int left = i;
//            int curHeight = heights[i];
//            while (left > 0 && heights[left-1]>=curHeight)
//            {
//                left--;
//            }
//
//            // 找右边最后一个大于等于 heights[i] 的索引
//            int right = i;
//            while (right < len - 1 && heights[right+1]>= curHeight)
//            {
//                right++;
//            }
//
//            int width = right - left + 1;
//            res = Math.max(res,width*curHeight);
//        }
//        return res;

        // more than use stack
        //         2, 1, 5, 6, 2, 3
        // index:  0, 1, 2, 3, 4, 5
        // left:   -1, -1, 1, 2, 1, 4
        // right:   1,  6, 4, 4, 6, 6
        // area:    2,  6, 10,6, 8, 3


        if (heights == null || heights.length == 0)
        {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];

        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i=1; i<heights.length; i++)
        {
            int p = i - 1;

            while (p>=0 && heights[p]>=heights[i])
            {
                p = lessFromLeft[p];
            }

            lessFromLeft[i] = p;
        }

        for (int i= heights.length - 2; i>=0; i--)
        {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i])
            {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i=0; i< heights.length;i++)
        {
            maxArea = Math.max(maxArea,heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
}

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }
}
