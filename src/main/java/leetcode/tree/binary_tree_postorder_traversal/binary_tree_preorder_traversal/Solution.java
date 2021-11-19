package leetcode.tree.binary_tree_postorder_traversal.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/15 19:52
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the postorder traversal of its nodes' values.
     *
     * Input: root = [1,null,2,3]
     * Output: [3,2,1]
     *
     * Input: root = []
     * Output: []
     *
     * Input: root = [1]
     * Output: [1]
     *
     * Input: root = [1,2]
     * Output: [2,1]
     *
     * Input: root = [1,null,2]
     * Output: [2,1]
     *
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root)
//    {
//        List<Integer> ret = new ArrayList<>();
//        preorder(root,ret);
//        return ret;
//    }

    private void preorder(TreeNode root, List<Integer> ret) {
        if(root != null)
        {
            preorder(root.left,ret);
            preorder(root.right,ret);
            ret.add(root.val);

        }
    }

    // 左-右-中  入栈顺序: 中-左-右 出栈顺序: 中-右-左,最后翻转
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left !=null)
            {
                stack.push(node.left);
            }
            if(node.right !=null)
            {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
