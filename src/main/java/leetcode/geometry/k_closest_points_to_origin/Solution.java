package leetcode.geometry.k_closest_points_to_origin;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/23 21:20
 */
public class Solution {

    /**
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0, 0).
     *
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     *
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     *
     *
     * Input: points = [[1,3],[-2,2]], k = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
     *
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
     * Output: [[3,3],[-2,4]]
     * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length, l=0,r=len - 1;
        while (l<=r)
        {
            int mid = helper(points,l,r);
            if(mid == k)
            {
                break;
            }
            if(mid < k)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points,0,k);
    }

    private int helper(int[][] a, int l, int r)
    {
        int[] pivot = a[l];
        while (l<r)
        {
            while (l<r && compare(a[r], pivot) >= 0)
            {
                r--;
            }
            a[l] = a[r];
            while (l<r && compare(a[l],pivot) <= 0)
            {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2)
    {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
