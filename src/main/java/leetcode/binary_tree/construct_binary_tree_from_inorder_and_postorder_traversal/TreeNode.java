package leetcode.binary_tree.construct_binary_tree_from_inorder_and_postorder_traversal;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/10/10 14:24
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
        this.right = right;
        this.left = left;
    }

}
