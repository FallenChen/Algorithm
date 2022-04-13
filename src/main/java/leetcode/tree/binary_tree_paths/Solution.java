package leetcode.tree.binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/9 20:16
 */
public class Solution
{
    /**
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * A leaf is a node with no children.
     *
     * Input: root = [1,2,3,null,5]
     * Output: ["1->2->5","1->3"]
     *
     * Input: root = [1]
     * Output: ["1"]
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        if (root != null)
        {
            searchBT(root, "", res);
        }
        return res;
    }

    private void searchBT(TreeNode root, String path, List<String> res)
    {
        if (root.left == null && root.right == null)
        {
            res.add(path + root.val);
        }
        if (root.left != null)
        {
            searchBT(root.left, path + root.val + "->", res);
        }
        if (root.right != null)
        {
            searchBT(root.right, path + root.val + "->", res);
        }
    }
}
