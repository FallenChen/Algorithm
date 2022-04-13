package leetcode.tree.minimum_depth_of_binary_tree;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/4 19:41
 */
public class Solution {

    /**
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     *
     * Input: root = [2,null,3,null,4,null,5,null,6]
     * Output: 5
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root== null)
        {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left==0 || right==0) ? left+right+1 : Math.min(left,right)+1;
    }
}
