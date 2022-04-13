package leetcode.graph.course_schedule;

import java.util.ArrayList;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/6 20:17
 */
public class Solution {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
     * you must take course bi first if you want to take course ai.
     *
     *     For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     *
     * Return true if you can finish all courses. Otherwise, return false.
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Using BFS || kahn' algo
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
        {
           graph[i] = new ArrayList<>();
        }
        for(int[] e : prerequisites)
        {
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for(int i=0; i<numCourses; i++)
        {
           if(degree[i] == 0)
           {
               bfs.add(i);
           }
        }

        for(int i=0; i<bfs.size(); i++)
        {
            for(int j: graph[bfs.get(i)])
            {
                if(--degree[j] == 0)
                {
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == numCourses;
    }
}
