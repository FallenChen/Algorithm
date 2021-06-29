package leetcode.string.excel_sheet_column_number;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/28 16:48
 */
public class Solution {

    /**
     * Given a string columnTitle that represents the column title as appear in an Excel sheet,
     * return its corresponding column number.
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     *
     * Input: columnTitle = "A"
     * Output: 1
     *
     * Input: columnTitle = "AB"
     * Output: 28
     *
     * Input: columnTitle = "ZY"
     * Output: 701
     *
     * Input: columnTitle = "FXSHRXW"
     * Output: 2147483647
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        // 701 = 26*26+ 25
        int reduce = columnTitle.chars().reduce(0, (r, ch) -> r * 26 + (ch - 'A' + 1));

        return reduce;
    }
}
