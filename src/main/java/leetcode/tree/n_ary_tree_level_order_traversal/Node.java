package leetcode.tree.n_ary_tree_level_order_traversal;

import java.util.List;

/**
 * @author cy
 * @className Node
 * @description
 * @date 2021/11/27 19:39
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
