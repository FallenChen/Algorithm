package leetcode.bit_manipulation.reverse_bits;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/6 20:32
 */
public class Solution {

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111
    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * Note:
     *
     *     Note that in some languages such as Java, there is no unsigned integer type.
     *     In this case, both input and output will be given as a signed integer type.
     *     They should not affect your implementation, as the integer's internal binary representation is the same,
     *     whether it is signed or unsigned.
     *
     *     In Java, the compiler represents the signed integers using 2's complement notation.
     *     Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
     *
     * Follow up:
     *
     * If this function is called many times, how would you optimize it?
     *
     * Input: n = 00000010100101000001111010011100
     * Output:    964176192 (00111001011110000010100101000000)
     * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
     *              so return 964176192 which its binary representation is 00111001011110000010100101000000.
     *
     * Input: n = 11111111111111111111111111111101
     * Output:   3221225471 (10111111111111111111111111111111)
     * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
     *              so return 3221225471 which its binary representation is 10111111111111111111111111111111.
     * @param n
     * @return
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // mask -> shift -> combine
        n = n >>> 1 & M1 | (n&M1) <<1;
        n = n >>> 2 & M2 | (n&M2) <<2;
        n = n >>> 4 & M4 | (n&M4) <<4;
        n = n >>> 8 & M8 | (n&M8) <<8;
        return n >>> 16 | n << 16;
    }
}
