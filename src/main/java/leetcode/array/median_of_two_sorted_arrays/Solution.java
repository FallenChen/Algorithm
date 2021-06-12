package leetcode.array.median_of_two_sorted_arrays;

public class Solution {


    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     * Input: nums1 = [0,0], nums2 = [0,0]
     * Output: 0.00000
     *
     * Input: nums1 = [], nums2 = [1]
     * Output: 1.00000
     *
     * Input: nums1 = [2], nums2 = []
     * Output: 2.00000
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;

        for(int i=0; i<=(nums1.length + nums2.length)/2; i++)
        {
            med1 = med2;
            // index1.length == 0
            if(index1 == nums1.length)
            {
                med2 = nums2[index2];
                index2++;
            }
            // index2.length == 0
            else if(index2 == nums2.length)
            {
                med2 = nums1[index1];
                index1++;
            }
            // index1 and index2 not empty
            else if(nums1[index1] < nums2[index2])
            {
                med2 = nums1[index1];
                index1++;
            }else
            {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if((nums1.length + nums2.length)%2 == 0)
        {
            return (float)(med1 + med2)/2;
        }

        return med2;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,5};
//        int[] num2 = {3,4};
        int[] num2 = {};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
