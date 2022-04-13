package leetcode.tree.binary_tree_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/21 20:18
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null)
        {
            st.push(root);
        }
        while (!st.empty())
        {
            TreeNode node = st.peek();
            if(node != null)
            {
                st.pop();
                if(node.right !=null)
                {
                    st.push(node.right);
                }
                if(node.left !=null)
                {
                    st.push(node.left);
                }
                st.push(node);
                st.push(null);

            }
            else
            {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null)
        {
            st.push(root);
        }
        while (!st.empty())
        {
            TreeNode node = st.peek();
            if(node != null)
            {
                st.pop();
                if(node.right !=null)
                {
                    st.push(node.right);
                }
                st.push(node);
                st.push(null);

                if(node.left !=null)
                {
                    st.push(node.left);
                }
            }
            else
            {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null)
        {
            st.push(root);
        }
        while (!st.empty())
        {
            TreeNode node = st.peek();
            if(node != null)
            {
                st.pop();
                st.push(node);
                st.push(null);
                if(node.right !=null)
                {
                    st.push(node.right);
                }

                if(node.left !=null)
                {
                    st.push(node.left);
                }
            }
            else
            {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
