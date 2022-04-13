package leetcode.bitmask.find_minimum_time_to_finish_all_jobs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/20 13:14
 */
public class Solution {

    /**
     * You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
     *
     * There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker.
     * The working time of a worker is the sum of the time it takes to complete all jobs assigned to them.
     * Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
     *
     * Input: jobs = [3,2,3], k = 3
     * Output: 3
     * Explanation: By assigning each person one job, the maximum time is 3.
     *
     * Input: jobs = [1,2,4,7,8], k = 2
     * Output: 11
     * Explanation: Assign the jobs the following way:
     * Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
     * Worker 2: 4, 7 (working time = 4 + 7 = 11)
     * The maximum working time is 11.
     *
     *
     * Return the minimum possible maximum working time of any assignment.
     * @param jobs
     * @param k
     * @return
     */

    int ret = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        assign(jobs, 0, new int[k], 0);
        return ret;
    }

    private void assign(int[] jobs, int i, int[] workloads, int preMax) {
        if(i == jobs.length)
        {
            ret = Math.min(ret, preMax);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int w=0; w<workloads.length; w++)
        {
            if(!used.add(workloads[w]))
            {
                continue;
            }
            if(workloads[w] + jobs[i] > ret)
            {
                continue;
            }
            workloads[w] += jobs[i];
            assign(jobs,i+1,workloads,Math.max(workloads[w], preMax));
            workloads[w] -= jobs[i];
        }
    }


}
