package leetcode.binary_tree.most_frequent_subtree_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/15 20:10
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the most frequent subtree sum.
     * If there is a tie, return all the values with the highest frequency in any order.
     *
     * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
     *
     * Input: root = [5,2,-3]
     * Output: [2,-3,4]
     *
     * Input: root = [5,2,-5]
     * Output: [2]
     * The bottom node with a value of 2 has a subtree num of 2.
     * Because it has 2 null sub-node and we consider both of them represent value of 0 which we dont consider in the final result,
     * and 0 plus the value of itself equals to 2. The sum of right subnode of root is -3.
     * So, now we see the root node, it has a subtree whose sum is 2 and another is -3,
     * so the sum of root node is 2 - 3 + 5 = 4. So, we can get three sum from three node,
     * each of them appear once, so we should return them together in a vector.
     * @param root
     * @return
     */

    Map<Integer, Integer> count = new HashMap<>();

    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root)
    {
        // use a hashMap count to count the subtree sum occurrence
        // A sub function dfs(TreeNode node) will
        // travel through a tree, recursively calculate the sum of subtree,
        // increment the count, and finally return the sum of the sub tree.

        dfs(root);

        List<Integer> res = new ArrayList<>();
        for(int s : count.keySet())
        {
            if(count.get(s) == maxCount)
            {
                res.add(s);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int s = dfs(root.left) + dfs(root.right) + root.val;
        count.put(s, count.getOrDefault(s,0) + 1);
        maxCount = Math.max(maxCount, count.get(s));
        return s;
    }
}
