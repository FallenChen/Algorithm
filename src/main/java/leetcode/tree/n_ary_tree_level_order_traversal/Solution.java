package leetcode.tree.n_ary_tree_level_order_traversal;

import leetcode.tree.binary_tree_level_traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/27 19:39
 */
public class Solution {


    public List<List<Integer>> levelOrder(Node root) {

        return dfs(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> dfs(Node node, int deep, List<List<Integer>> res) {
        if (node == null) {
            return res;
        }
        if (res.size() == deep) {
            List<Integer> items = new ArrayList<>();
            res.add(items);
        }
        res.get(deep).add(node.val);

        for (Node child : node.children) {
            dfs(child, deep + 1, res);
        }
        return res;
    }
}
