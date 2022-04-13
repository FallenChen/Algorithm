package leetcode.tree.kth_smallest_element_in_a_bst;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/8/27 19:37
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
