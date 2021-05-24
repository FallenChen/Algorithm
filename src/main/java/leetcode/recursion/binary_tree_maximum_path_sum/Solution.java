package leetcode.recursion.binary_tree_maximum_path_sum;

/**
 * @author cy
 * @className Soluction
 * @description TODO
 * @date 2021/5/21 15:02
 */
public class Solution {

    int maxValue;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
     * A node can only appear in the sequence at most once.
     * Note that the path does not need to pass through the root.
     *
     * The path sum of a path is the sum of the node's values in the path.
     *
     * Input: root = [1,2,3]
     * Output: 6
     * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
     *
     * Input: root = [-10,9,20,null,null,15,7]
     * Output: 42
     * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        // the sum might be negative,so 0 is not the min
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        // must have node,so if < 0 then use 0 to continue
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        // maxValue is the value which recording whether this current root is the fina root
        maxValue = Math.max(maxValue,(left + right + node.val));
        // first,return value used in left or right value,so that the program execution can continue
        // second, returns the maximum sum of the path that can be extended to input node's parent
        return Math.max(left,right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1,leftNode,rightNode);

        Solution solution = new Solution();
        int sum = solution.maxPathSum(treeNode);
        System.out.println(sum);

    }
}
