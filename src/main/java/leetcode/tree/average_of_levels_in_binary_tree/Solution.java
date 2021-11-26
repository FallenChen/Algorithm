package leetcode.tree.average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/26 10:26
 */
public class Solution {

    /**
     * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
     * Answers within 10-5 of the actual answer will be accepted.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [3.00000,14.50000,11.00000]
     * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
     * Hence return [3, 14.5, 11].
     *
     * Input: root = [3,9,20,15,7]
     * Output: [3.00000,14.50000,11.00000]
     *
     * @param root
     * @return
     */
    // DFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        average(root, level, res, 0);
        for(int i = 0; i < res.size(); i++)
        {
            res.set(i, res.get(i) / level.get(i));
        }
        return res;
    }

    private void average(TreeNode root, List<Integer> level, List<Double> sum, int deep)
    {
        if(root == null)
        {
            return;
        }

        if(deep < sum.size())
        {
            sum.set(deep, sum.get(deep) + root.val);
            level.set(deep, level.get(deep) + 1);
        }
        // when not exist, add new
        else
        {
            sum.add(1.0 * root.val);
            level.add(1);
        }

        average(root.left, level, sum, deep + 1);
        average(root.right, level, sum, deep + 1);

    }


    // BFS
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty())
//        {
//            int count = queue.size();
//            double sum = 0;
//            for(int i=0; i<count; i++)
//            {
//                TreeNode node = queue.poll();
//                sum += node.val;
//                if(node.left != null)
//                {
//                    queue.offer(node.left);
//                }
//                if (node.right != null)
//                {
//                    queue.offer(node.right);
//                }
//            }
//            res.add(sum/count);
//        }
//        return res;
//    }


}
