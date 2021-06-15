package leetcode.dynamic_programming.kth_ancestor_of_a_tree_node;

public class TreeAncestor {


    /**
     * You are given a tree with n nodes numbered from 0 to n-1 in the form of a parent array where parent[i] is the parent of node i.
     * The root of the tree is node 0.
     *
     * Implement the function getKthAncestor(int node, int k) to return the k-th ancestor of the given node.
     * If there is no such ancestor, return -1.
     *
     * The k-th ancestor of a tree node is the k-th node in the path from that node to the root.
     *
     * Input:
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
     *
     * Output:
     * [null,1,0,-1]
     *
     * Explanation:
     * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
     *
     * treeAncestor.getKthAncestor(3, 1);  // returns 1 which is the parent of 3
     * treeAncestor.getKthAncestor(5, 2);  // returns 0 which is the grandparent of 5
     * treeAncestor.getKthAncestor(6, 3);  // returns -1 because there is no such ancestor
     *
     *
     * @param n
     * @param parent
     */

    int[][] dp;
    int maxPower;
    public TreeAncestor(int n, int[] parent) {

        this.maxPower = (int)((Math.log(n)) / Math.log(2)) + 1;
        this.dp = new int[maxPower][n];
        dp[0] = parent;
        for(int i=1; i<maxPower;i++)
        {
            for(int j=0; j<n; j++)
            {
                int pre_ancestor = dp[i-1][j];
                if(pre_ancestor == -1)
                {
                    dp[i][j] = -1;
                }else
                {
                    dp[i][j] = dp[i-1][pre_ancestor];
                }
            }
        }

    }

    public int getKthAncestor(int node, int k) {

        int curPower = this.maxPower;// base 2
        while (k>00 && node >=0)
        {
            if(k >=(1<<curPower))
            {
                node = dp[curPower][node];
                k -= (1<<curPower);
            }else
            {
                curPower -= 1;
            }
        }

        return node;
    }

}
