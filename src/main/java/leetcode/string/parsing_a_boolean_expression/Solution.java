package leetcode.string.parsing_a_boolean_expression;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/31 17:06
 */
public class Solution {


    /**
     * Return the result of evaluating a given boolean expression, represented as a string.
     *
     * An expression can either be:
     *
     *     "t", evaluating to True;
     *     "f", evaluating to False;
     *     "!(expr)", evaluating to the logical NOT of the inner expression expr;
     *     "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
     *     "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...
     *
     * Input: expression = "!(f)"
     * Output: true
     *
     * Input: expression = "|(f,t)"
     * Output: true
     *
     * Input: expression = "&(t,f)"
     * Output: false
     *
     * Input: expression = "|(&(t,f,t),!(t))"
     * Output: false
     *
     * @param expression
     * @return
     */

    // a global source code position marker
    int pos = 0;
    String src = "";

    public boolean parseBoolExpr(String expression) {

        //BNF grammar for this language of booleans and we will implement a recursive descent parser for it.

        /**
         * <comma> ::= ","
         * <bool> ::= "t" | "f"
         * <lparen> ::= "("
         * <rparen> ::= ")"
         * <not_expr> ::= "!" <lparen> <expr> <rparen>
         * <and_expr> ::= "&" <lparen> <expr> (<comma> <expr>)+ <rparen>
         * <or_expr> ::= "|" <lparen> <expr> (<comma> <expr>)+ <rparen>
         * <expr> ::= <bool> | <not_expr> | <and_expr> | <or_expr>
         */
        pos = 0;
        src = expression;
        // call the entry rule
        return parseExpr();
    }

    private boolean parseExpr()
    {
        // //<expr> ::= "t"
        if(src.charAt(pos) == 't')
        {
            ++pos;
            return true;
        }
        if (src.charAt(pos) == 'f')
        {
            ++pos;
            return false;
        }

        boolean result = false;
        switch (src.charAt(pos))
        {
            // <not_expr> ::= "!" <lparen><expr><rparem>
            case '!':
                pos++; // eat operator
                result = parseNotExpr();
                break;
            //<or_expr> ::= "|" <lparen> <expr> (<comma> <expr>)+ <rparen>
            case '|':
                //eat operator
                pos++;
                result = parseOrExpr();
                break;
            //<and_expr> ::= "&" <lparen> <expr> (<comma> <expr>)+ <rparen>
            case '&':
                // eat operator
                pos++;
                result = parseAndExpr();
                break;
        }
        return result;
    }

    private boolean parseNotExpr()
    {
        ++pos;//eat lparen
        boolean result = parseExpr();
        ++pos;//eat rparen
        return !result;
    }

    private boolean parseOrExpr()
    {
        //eat rparen
        ++pos;
        boolean result = parseExpr();
        while (pos < src.length() && src.charAt(pos) !=')')
        {
            if(src.charAt(pos) == ',')
            {
                ++pos;
            }
            else
            {
                result |= parseExpr();
            }
        }
        //eat rparen
        ++pos;
        return result;
    }

    private boolean parseAndExpr()
    {
        ++pos;
        boolean result = parseExpr();
        while (pos < src.length() && src.charAt(pos) !=')')
        {
            if(src.charAt(pos) == ',')
            {
                ++pos;
            }
            else
            {
                result &= parseExpr();
            }
        }
        ++pos;
        return result;
    }
}
