package leetcode.recursion.permutation_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/17 19:47
 */
public class Solution {

    /**
     * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
     *
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     *
     *     "123"
     *     "132"
     *     "213"
     *     "231"
     *     "312"
     *     "321"
     *
     * Given n and k, return the kth permutation sequence.
     *
     * Input: n = 3, k = 3
     * Output: "213"
     *
     * Input: n = 4, k = 9
     * Output: "2314"
     *
     * Input: n = 3, k = 1
     * Output: "123"
     *
     * @param n
     * @param k
     * @return
     */


    public String getPermutation(int n, int k)
    {
//        StringBuilder sb = new StringBuilder();
//        ArrayList<Integer> num = new ArrayList<>();
//        int fact = 1;
//        for(int i=1; i<=n; i++)
//        {
//            fact *= i;
//            num.add(i);
//        }
//
//        for(int i=0, l=k-1; i<n; i++)
//        {
//            fact /= (n - i);
//            int index = (l / fact);
//            sb.append(num.remove(index));
//            l -= index * fact;
//        }
//
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        int[] array = new int[n+1];

        for(int i=0; i<n; i++)
        {
            array[i] = i + 1;
        }

        array[n] = 0;

        int perm = 1;
        for(int i=1; i<=n; i++)
        {
            perm *= i;
        }

        doPermutationHelper(array,perm,n,k,sb);
        return sb.toString();
    }

    private void doPermutationHelper(int[] a, int perm, int n, int k, StringBuilder sb)
    {
        if(n == 1)
        {
            sb.append(a[0]);
            return;
        }

        perm /= n;
        int i = (k-1)/perm;

        sb.append(a[i]);

        while (i<n-1)
        {
            a[i++] = a[i];
        }
        doPermutationHelper(a,perm,n-1,(k-1)%perm + 1, sb);
    }
}
