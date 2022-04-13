package leetcode.backtracking.combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description 
 * @date 2021/9/5 19:45
 */
public class Solution {

    /**
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     * <p>
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * <p>
     * Return a list of all possible valid combinations.
     * The list must not contain the same combination twice, and the combinations may be returned in any order.
     * <p>
     * <p>
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Explanation:
     * 1 + 2 + 4 = 7
     * There are no other valid combinations.
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     * Explanation:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * There are no other valid combinations.
     * <p>
     * Input: k = 4, n = 1
     * Output: []
     * Explanation: There are no valid combinations.
     * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
     * <p>
     * Input: k = 3, n = 2
     * Output: []
     * Explanation: There are no valid combinations.
     * <p>
     * Input: k = 9, n = 45
     * Output: [[1,2,3,4,5,6,7,8,9]]
     * Explanation:
     * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
     * There are no other valid combinations.
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() > k) {
            return;
        }

        if (n == 0 && comb.size() == k) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i >= 0) {
                comb.add(i);
                combination(ans, comb, k, i + 1, n - i);
                comb.remove(comb.size() - 1);
            }
        }
    }


}
