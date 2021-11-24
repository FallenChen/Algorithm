package leetcode.tree.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/24 20:16
 */
public class Solution {

    /**
     * Given the root of a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * Input: root = [1,2,3,null,5,null,4]
     * Output: [1,3,4]
     *
     * Input: root = [1,null,3]
     * Output: [1,3]
     *
     * Input: root = []
     * Output: []
     *
     * @param root
     * @return
     */



    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> resList = new ArrayList<>();
        rightView(root,resList,0);
        return resList;
    }

    private void rightView(TreeNode node, List<Integer> result, int deep) {
        if(node == null)
        {
            return;
        }
        if (deep == result.size())
        {
            result.add(node.val);
        }

        rightView(node.right,result,deep+1);
        rightView(node.left, result,deep+1);
    }
}
