package leetcode.tree.count_complete_tree_nodes;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/12/7 19:54
 */
public class TreeNode {
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
