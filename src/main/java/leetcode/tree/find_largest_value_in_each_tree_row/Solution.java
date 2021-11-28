package leetcode.tree.find_largest_value_in_each_tree_row;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/28 14:12
 */
public class Solution {

    /**
     * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
     *
     * Input: root = [1,3,2,5,3,null,9]
     * Output: [1,3,9]
     *
     * Input: root = [1,2,3]
     * Output: [1,3]
     *
     * Input: root = [1]
     * Output: [1]
     *
     * Input: root = [1,null,2]
     * Output: [1,2]
     *
     * Input: root = []
     * Output: []
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int deep, List<Integer> res) {
        if (root == null)
        {
            return;
        }

        // expand list size
        if(deep == res.size())
        {
            res.add(root.val);
        }
        else
        {
            // set max value
            res.set(deep, Math.max(res.get(deep), root.val));
        }
        dfs(root.left, deep + 1, res);
        dfs(root.right, deep + 1, res);
    }

    // BFS
    public List<Integer> largestValueBFS(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root != null)
        {
            queue.offer(root);
        }

        while (!queue.isEmpty())
        {
            int max = Integer.MIN_VALUE, n = queue.size();

            for(int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null)
                {
                    queue.offer(node.left);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
                res.add(max);
            }
        }
        return res;
    }

}
