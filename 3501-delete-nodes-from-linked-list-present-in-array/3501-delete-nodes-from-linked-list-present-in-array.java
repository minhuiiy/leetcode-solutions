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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> del = new HashSet<>();
        for(int x : nums) del.add(x);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, cur = head;
        while(cur != null) {
            if(del.contains(cur.val)) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}