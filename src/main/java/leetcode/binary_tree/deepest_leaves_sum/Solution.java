package leetcode.binary_tree.deepest_leaves_sum;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/28 20:11
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the sum of values of its deepest leaves.
     *
     * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * Output: 15
     *
     * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * Output: 19
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {

        /**
         * When current level are empty,
         * the previous level are the deepest leaves.
         */
//        int res = 0, i;
//
//        LinkedList<TreeNode> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty())
//        {
//            for(i = q.size()-1, res = 0; i>=0; --i)
//            {
//                TreeNode node = q.poll();
//                res += node.val;
//                if(node.right != null)
//                {
//                    q.add(node.right);
//                }
//
//                if(node.left != null)
//                {
//                    q.add(node.left);
//                }
//            }
//        }
//
//        return res;

        int dep = getDepth(root);
        return getSumAtLevel(root,dep);
    }

    private int getSumAtLevel(TreeNode root, int level) {
        if(root == null)
        {
            return 0;
        }
        if(level == 1)
        {
            return root.val;
        }

        return getSumAtLevel(root.left, level -1 ) + getSumAtLevel(root.right, level - 1);
    }

    private int getDepth(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        return 1 + Math.max(getDepth(root.right), getDepth(root.left));
    }


}
