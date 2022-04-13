package leetcode.dynamic_programming.unique_binary_search_trees;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/5 19:37
 */
public class Solution {

    /**
     * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
     *
     * Input: n = 3
     * Output: 5
     *
     * Input: n = 1
     * Output: 1
     *
     * dp[3]，就是 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
     *
     * 元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
     *
     * 元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
     *
     * 元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
     *
     * 有2个元素的搜索树数量就是dp[2]。
     *
     * 有1个元素的搜索树数量就是dp[1]。
     *
     * 有0个元素的搜索树数量就是dp[0]。
     *
     * 所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     * dp[3] += dp[0]*dp[2]
     * dp[3] += dp[1]*dp[1]
     * dp[3] += dp[2]*dp[0]
     *
     * n = 5
     *
     * 0  1  2  3  4  5
     * 1  1  2  5  14 42
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // 1. 初始化dp数组
        int[] dp = new int[n+1];
        // 3. 初始化
        dp[0] = 1;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                // j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
