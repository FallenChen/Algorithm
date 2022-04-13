package leetcode.greedy.di_string_match;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/15 21:36
 */
public class Solution {

    /**
     * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
     *
     *     s[i] == 'I' if perm[i] < perm[i + 1], and
     *     s[i] == 'D' if perm[i] > perm[i + 1].
     *
     * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
     *
     * Input: s = "IDID"
     * Output: [0,4,1,3,2]
     *
     * Input: s = "III"
     * Output: [0,1,2,3]
     *
     * Input: s = "DDI"
     * Output: [3,2,0,1]
     *
     * @param s
     * @return
     */
    public int[] diStringMatch(String s)
    {
//        suppose S.length = 4 and S="IDID", so the numbers we need to fill in the result set is 0 1 2 3 4
//        if the current char is 'I', we want to pick a number in the current potential options (0-4) that satisfies all scenarios in next loop, it should be the smallest one, which is 0
//        now the rest of options are 1 2 3 4
//        if the current char is 'D', again, we want to make sure that FOR EVERY NUMBER WE PICK IN NEXT ROUND will satisfy a[current] > a[current+1], then pick the largest value in 1 2 3 4, which is 4
//        then set becomes [1 2 3], we repeat the above
//        the thinking is really similar to "greedy" that we pick some number that can most satisfy the cases for next loop
//        0 4 1 3 2
        int n = s.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for(int i=0; i<n; i++)
        {
            res[i] = s.charAt(i) == 'I' ? left++: right--;
        }
        res[n] = left;
        return res;
    }
}
