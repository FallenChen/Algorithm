package leetcode.graph.find_the_town_judge;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/27 19:57
 */
public class Solution {

    /**
     * In a town, there are n people labeled from 1 to n.
     * There is a rumor that one of these people is secretly the town judge.
     *
     * If the town judge exists, then:
     *
     *     The town judge trusts nobody.
     *     Everybody (except for the town judge) trusts the town judge.
     *     There is exactly one person that satisfies properties 1 and 2.
     *
     * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
     *
     * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
     *
     * Input: n = 2, trust = [[1,2]]
     * Output: 2
     *
     * Input: n = 3, trust = [[1,3],[2,3]]
     * Output: 3
     *
     * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     * Output: -1
     *
     * Input: n = 3, trust = [[1,2],[2,3]]
     * Output: -1
     *
     * Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * Output: 3
     *
     * @param n
     * @param trust
     * @return
     */
    public static int findJudge(int n, int[][] trust)
    {
        int[] count = new int[n + 1];
        for(int[] t: trust)
        {
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i=1; i<=n; ++i)
        {
            if(count[i] == n - 1)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust =  {{1,3}, {1,4}, {2,3}, {4,3}};
        int n = 4;
        int judge = findJudge(n, trust);
        System.out.println(judge);
    }
}
