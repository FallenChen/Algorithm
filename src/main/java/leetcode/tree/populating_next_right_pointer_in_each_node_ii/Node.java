package leetcode.tree.populating_next_right_pointer_in_each_node_ii;

/**
 * @author cy
 * @className Node
 * @description
 * @date 2021/11/29 20:25
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
