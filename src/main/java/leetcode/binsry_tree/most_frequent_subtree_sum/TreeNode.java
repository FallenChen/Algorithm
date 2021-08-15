package leetcode.binsry_tree.most_frequent_subtree_sum;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/8/15 20:10
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode()
    {

    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
