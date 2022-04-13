package leetcode.tree.sum_of_left_leaves;

/**
 * @author cy
 * @className SumOfLeftLeaves
 * @description
 * @date 2021/12/10 19:32
 */
public class Solution
{
    /**
     * Given the root of a binary tree, return the sum of all left leaves.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 24
     * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
     *
     * Input: root = [1]
     * Output: 0
     *
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        int ans = 0;

        if(root.left != null)
        {
            if(root.left.left == null && root.left.right == null)
            {
                ans += root.left.val;
            }
            else
            {
                ans += sumOfLeftLeaves(root.left);
            }
        }

        ans += sumOfLeftLeaves(root.right);

        return ans;
    }
}
