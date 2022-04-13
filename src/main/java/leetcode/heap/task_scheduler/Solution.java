package leetcode.heap.task_scheduler;

import java.util.*;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/14 20:20
 */
public class Solution {

    /**
     * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
     * Tasks could be done in any order. Each task is done in one unit of time.
     * For each unit of time, the CPU could complete either one task or just be idle.
     *
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
     * that is that there must be at least n units of time between any two same tasks.
     *
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation:
     * A -> B -> idle -> A -> B -> idle -> A -> B
     * There is at least 2 units of time between any two same tasks.
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 0
     * Output: 6
     * Explanation: On this case any permutation of size 6 would work since n = 0.
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * And so on.
     *
     * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * Output: 16
     * Explanation:
     * One possible solution is
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     *
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n)
    {
        if(tasks == null || tasks.length == 0)
        {
            return -1;
        }
        // build map to sum the amount of each task
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:  tasks)
        {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        // build queue, sort from descending
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        queue.addAll(map.entrySet());

        int count = 0;
        // when queue is not empty. there are remaining tasks
        while (!queue.isEmpty())
        {
            // for each interval
            int interval = n + 1;
            // list used to update queue
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();

            // fill the intervals with the next high freq task
            while (interval > 0 && !queue.isEmpty())
            {
                // most frequency task
                Map.Entry<Character, Integer> entry = queue.poll();
                // decrease frequency, meaning it got executed
                entry.setValue(entry.getValue() - 1);
                // collect task to add back to queue
                list.add(entry);
                // interval shrinks
                interval--;
                // one slot is taken, successfully executed task
                count++;
            }

            // update the value in the map
            for(Map.Entry<Character, Integer> entry: list)
            {
                // when there is left task
                if(entry.getValue() > 0)
                {
                    queue.offer(entry);
                }
            }
            // job done
            if(queue.isEmpty())
            {
                break;
            }
            // if interval is > 0, then the machine can only be idle
            count += interval;
        }

        return count;
    }
}
