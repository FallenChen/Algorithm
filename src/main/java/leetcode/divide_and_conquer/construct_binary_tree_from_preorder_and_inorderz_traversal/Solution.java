package leetcode.divide_and_conquer.construct_binary_tree_from_preorder_and_inorderz_traversal;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/8 19:58
 */
public class Solution {

    /**
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
     * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     *
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length - 1, preorder, inorder);
    }

    /**
     * Say we have 2 arrays, PRE and IN.
     * Preorder traversing implies that PRE[0] is the root node.
     * Then we can find this PRE[0] in IN, say it's IN[5].
     * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
     * Recursively doing this on subarrays, we can build a tree out of it :)
     * @param preStart
     * @param inStart
     * @param inEnd
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for(int i = inStart; i <= inEnd; i++)
        {
            if(inorder[i] == root.val)
            {
                inIndex = i;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
