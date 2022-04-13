package leetcode.tree.symmetric_tree;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/6 19:46
 */
public class Solution
{
    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     *
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     *
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     *
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right)
    {
        if(left == null || right == null)
        {
            return left == right;
        }
        if(left.val != right.val)
        {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }


}
