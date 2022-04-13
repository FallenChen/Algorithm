package leetcode.linked_list.split_linked_list_in_parts;

/**
 * @author cy
 * @className Soulution
 * @description TODO
 * @date 2021/9/10 16:38
 */
public class Solution {

    /**
     * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
     *
     * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
     * This may lead to some parts being null.
     *
     * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always
     * have a size greater than or equal to parts occurring later.
     *
     * Return an array of the k parts.
     *
     * Input: head = [1,2,3], k = 5
     * Output: [[1],[2],[3],[],[]]
     * Explanation:
     * The first element output[0] has output[0].val = 1, output[0].next = null.
     * The last element output[4] is null, but its string representation as a ListNode is [].
     *
     * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
     * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
     * Explanation:
     * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for(ListNode node = head; node != null; node = node.next)
        {
            len++;
        }
        // n: minimum guaranteed part size; r:extra nodes spread to the first r parts
        int n = len / k, r = len % k;
        ListNode node = head, prev = null;
        for(int i=0; node !=null&& i<k; i++,r--)
        {
            parts[i] = node;
            for(int j=0; j<n+(r >0 ? 1 : 0); j++)
            {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;
    }
}
