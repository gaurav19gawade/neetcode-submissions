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
    public void reorderList(ListNode head) {
        //Find the middle of the list
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode reversed = listReversal(slow.next);
        slow.next = null;
        

        ListNode first = head;
        ListNode second = reversed;
        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public ListNode listReversal(ListNode list){
        ListNode prev = null;
        ListNode curr = list;

        while(curr != null){
            ListNode temp = curr;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
