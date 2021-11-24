package leetcode.tree.binary_tree_level_traversal_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/22 19:47
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (i.e., from left to right, level by level from leaf to root).
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[15,7],[9,20],[3]]
     *
     * Input: root = [1]
     * Output: [[1]]
     *
     * Input: root = []
     * Output: []
     *
     * @param root
     * @return
     */
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root,0);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = resList.size() - 1; i>=0; i--)
        {
            list.add(resList.get(i));
        }
        return list;
    }

    private void dfs(TreeNode node, int deep) {
        if(node == null)
        {
            return;
        }
        deep++;

        if(resList.size() < deep)
        {
            List<Integer> items = new ArrayList<>();
            resList.add(items);
        }
        resList.get(deep - 1).add(node.val);

        dfs(node.left, deep);
        dfs(node.right,deep);
    }
}
