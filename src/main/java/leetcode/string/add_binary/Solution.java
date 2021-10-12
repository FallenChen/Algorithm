package leetcode.string.add_binary;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/12 19:55
 */
public class Solution {

    /**
     * Given two binary strings a and b, return their sum as a binary string.
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     *
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0)
        {
            int sum = carry;

            if(j >= 0)
            {
                sum += b.charAt(j--) - '0';
            }
            if(i >= 0)
            {
                sum += a.charAt(i--) - '0';
            }
            // if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            sb.append(sum % 2);
            // if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
            carry = sum / 2;
        }
        if(carry != 0)
        {
            // leftover carry, add it
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
