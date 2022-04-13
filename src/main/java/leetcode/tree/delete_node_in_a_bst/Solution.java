package leetcode.tree.delete_node_in_a_bst;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/14 20:08
 */
public class Solution {

    /**
     * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
     *
     * Basically, the deletion can be divided into two stages:
     *
     *     Search for a node to remove.
     *     If the node is found, delete the node.
     *
     *  Input: root = [5,3,6,2,4,null,7], key = 3
     * Output: [5,4,6,2,null,null,7]
     * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
     * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
     * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
     *
     * Input: root = [5,3,6,2,4,null,7], key = 0
     * Output: [5,3,6,2,4,null,7]
     * Explanation: The tree does not contain a node with value = 0.
     *
     * Input: root = [], key = 0
     * Output: []
     *
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key)
    {
        // node doesn't have left or right child
        if (root == null)
        {
            return null;
        }
        
        if(key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        
        else if(key > root.val)
        {
            root.right = deleteNode(root.right,key);
        }
        else
        {
            // node only has right subtree- return the right subtree
            if(root.left == null)
            {
                return root.right;
            }
            // node only has left subtree- return the left subtree
            if(root.right == null)
            {
                return root.left;
            }
            // node has both left and right - find the minimum value in the right subtree, 
            // set that value to the currently found node, 
            // then recursively delete the minimum value in the right subtree
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node)
    {
        while (node.left != null)
        {
            node = node.left;
        }
        return node;
    }
}
