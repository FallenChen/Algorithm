package leetcode.binary_tree.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.HashMap;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/10 14:25
 */
public class Solution {

    /**
     * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
     * postorder is the postorder traversal of the same tree, construct and return the binary tree.
     *
     * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * Output: [3,9,20,null,null,15,7]
     *
     * Input: inorder = [-1], postorder = [-1]
     * Output: [-1]
     *
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder,int[] postorder)
    {
        // take the last element in postorder array as the root,
        // find the position of the root in the inorder array;
        // then locate the range for left sub-tree and right sub-tree and do recursion.
        // Use a HashMap to record the index of root in the inorder array.


        // is - start index for inorder array
        // ie - end index for inorder array
        //
        // ps - start index for postorder array
        // pe - end index for postorder array
        //
        //Remember :
        // InOrder is (left subtree) node (right subtree)
        // PostOrder is (left subtree)(right subtree) (node)
        // From post order array we get the root which will be at index pe
        // while from in order we can get the number of children in the left subtree ie. ri-is

        if(inorder == null || postorder == null || inorder.length != postorder.length)
        {
            return null;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            hm.put(inorder[i],i);
        }
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if(ps > pe || is > ie)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftChild = buildTreePostIn(inorder,is,ri-1, postorder, ps, ps+ri-is-1,hm);
        TreeNode rightChild = buildTreePostIn(inorder,ri+1,ie, postorder, ps+ri-is, pe-1,hm);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
