package leetcode.tree.find_bottom_left_tree_value;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/11 15:09
 */
public class Solution
{
    /**
     * Given the root of a binary tree, return the leftmost value in the last row of the tree.
     *
     * Input: root = [2,1,3]
     * Output: 1
     *
     * Input: root = [1,2,3,4,null,5,6,null,null,7]
     * Output: 7
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root)
    {
        return findBottomLeftValue(root,1,new int[]{0,0});
    }

    private int findBottomLeftValue(TreeNode root, int depth, int[] res)
    {
        if(res[1]<depth)
        {
            res[0]=root.val;
            res[1]=depth;
        }
        // preorder traversal ,left first
        if(root.left!=null)
        {
            findBottomLeftValue(root.left,depth+1,res);
        }
        if (root.right!=null)
        {
            findBottomLeftValue(root.right,depth+1,res);
        }
        return res[0];
    }
}
