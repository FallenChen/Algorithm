package leetcode.depth_first_search.employee_importance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/23 20:22
 */
public class Solution {

    /**
     * You have a data structure of employee information, which includes the employee's unique id,
     * their importance value, and their direct subordinates' id.
     *
     * You are given an array of employees employees where:
     *
     *     employees[i].id is the ID of the ith employee.
     *     employees[i].importance is the importance value of the ith employee.
     *     employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
     *
     * Given an integer id that represents the ID of an employee,
     * return the total importance value of this employee and all their subordinates.
     *
     * Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
     * Output: 11
     * Explanation: Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
     * They both have importance value 3.
     * So the total importance value of employee 1 is 5 + 3 + 3 = 11.
     *
     * Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
     * Output: -3
     *
     * @param employees
     * @param id
     * @return
     */

    Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int id)
    {
        emap = new HashMap<>();
        for(Employee e : employees)
        {
            emap.put(e.id,e);
        }
        return dfs(id);
    }

    public int dfs(int id)
    {
        Employee employee = emap.get(id);
        int ans = employee.importance;
        for(Integer subid: employee.subordinates)
        {
            ans += dfs(subid);
        }
        return ans;
    }
}
