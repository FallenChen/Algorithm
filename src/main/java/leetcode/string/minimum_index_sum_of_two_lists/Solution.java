package leetcode.string.minimum_index_sum_of_two_lists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/19 21:04
 */
public class Solution {

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
     *
     * You need to help them find out their common interest with the least list index sum.
     * If there is a choice tie between answers, output all of them with no order requirement.
     * You could assume there always exists an answer.
     *
     * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
     * Output: ["Shogun"]
     * Explanation: The only restaurant they both like is "Shogun".
     *
     * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
     * Output: ["Shogun"]
     * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
     *
     * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
     * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
     *
     * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
     * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
     *
     * Input: list1 = ["KFC"], list2 = ["KFC"]
     * Output: ["KFC"]
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<list1.length; i++)
        {
            map.put(list1[i],i);
        }

        for(int i=0; i< list2.length; i++)
        {
            Integer j = map.get(list2[i]);
            if(j != null && i + j <= minSum)
            {
                if(i + j < minSum)
                {
                    res.clear();
                    minSum = i+j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
