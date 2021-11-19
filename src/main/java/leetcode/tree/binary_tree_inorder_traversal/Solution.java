package leetcode.tree.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/6/29 17:30
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        recursive(root,res);
//        stack(root,res);
        morris(root,res);
        return res;
    }

    private void morris(TreeNode root, List<Integer> res) {
        TreeNode cur = root;
        while (cur != null)
        {
            if(cur.left != null)
            {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur))
                {
                    pre = pre.right;
                }
                if(pre.right == null)
                {
                    pre.right = cur;
                    cur = cur.left;
                }
                else
                {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
            else
            {
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }

    // 左-中-右， 入栈顺序:左-右
    private void stack(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
    }

    // Recursive Approach
    private void recursive(TreeNode root, List<Integer> res) {
        if(root != null)
        {
            if(root.left != null)
            {
                recursive(root.left,res);
            }
            res.add(root.val);
            if(root.right != null)
            {
                recursive(root.right,res);
            }
        }
    }


}
