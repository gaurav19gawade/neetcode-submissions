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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int result = 0;
        ListNode resultNode = new ListNode();
        ListNode curr = resultNode;
        

        while(l1 != null || l2 != null || carry != 0){
            int v1 = 0, v2 = 0;
            if(l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;                
            }

            result = v1 + v2 + carry;

            carry = result / 10;

            curr.next = new ListNode(result % 10);
            curr = curr.next;
        }
        return resultNode.next;
    }
}
