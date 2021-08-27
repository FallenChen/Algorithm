package leetcode.tree.kth_smallest_element_in_a_bst;

import java.util.ArrayList;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/27 19:37
 */
public class Solution {

    /**
     * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
     *
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     *
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k)
    {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null)
        {
            return arr;
        }
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        return arr;
    }


}
