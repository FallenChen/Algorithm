package leetcode.sliding_window.repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/14 20:02
 */
public class Solution {

    /**
     * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     *
     *     For example, "ACGAATTCCG" is a DNA sequence.
     *
     * When studying DNA, it is useful to identify repeated sequences within the DNA.
     *
     * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     * You may return the answer in any order.
     *
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC","CCCCCAAAAA"]
     *
     * Input: s = "AAAAAAAAAAAAA"
     * Output: ["AAAAAAAAAA"]
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for(int i=0; i+9 < s.length(); i++)
        {
            String ten = s.substring(i, i+10);
            if(!seen.add(ten))
            {
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }
}
