/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while(true) {
            ListNode kth = getKthNode(prevGroup, k);
            if(kth == null) break;

            ListNode nextGroup = kth.next;

            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;
            while(curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = tmp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }

        return start;
    }
}