package leetcode.stack.daily_temperatures;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/5 17:22
 */
public class Solution {

    /**
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     *
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     *
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++)
        {
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] dailyTemperatures = dailyTemperatures(temperatures);
        Arrays.stream(dailyTemperatures)
                .forEach(x -> System.out.printf(x + " "));
    }


}
