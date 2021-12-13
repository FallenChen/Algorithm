package leetcode.tree.path_sum;

/**
 * @author cy
 * @className TreeNode
 * @description
 * @date 2021/12/13 17:25
 */
public class TreeNode
{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
