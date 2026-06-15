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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr;
            ListNode next = curr.next;
            temp.next = prev;
            prev = temp;
            curr = next;
        }
        return prev;
    }
}
