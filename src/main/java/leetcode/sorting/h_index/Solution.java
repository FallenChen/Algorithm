package leetcode.sorting.h_index;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/3 14:02
 */
public class Solution {

    /**
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
     * return compute the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each,
     * and the other n − h papers have no more than h citations each.
     *
     * If there are several possible values for h, the maximum one is taken as the h-index.
     *
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     *
     * Input: citations = [1,3,1]
     * Output: 1
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c: citations)
        {
            if(c >= n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i=n; i>=0; i--)
        {
            count += buckets[i];
            if(count >= i)
            {
                return i;
            }
        }
        return 0;
    }
}
