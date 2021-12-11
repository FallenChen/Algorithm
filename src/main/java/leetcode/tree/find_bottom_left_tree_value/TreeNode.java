package leetcode.tree.find_bottom_left_tree_value;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/12/11 15:08
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
