package leetcode.simulation.multiply_string;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/7 19:51
 */
public class Solution {

    /**
     * Given two non-negative integers num1 and num2 represented as strings,
     * return the product of num1 and num2, also represented as a string.
     * <p>
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * <p>
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * <p>
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p1] += sum /10;
                pos[p2]  = (sum)%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos)
        {
            if(!(sb.length() == 0 && p == 0))
            {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
