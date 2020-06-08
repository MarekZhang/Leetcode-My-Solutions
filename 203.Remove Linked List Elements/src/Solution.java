/**
 * 203. Remove Linked List Elements
Easy

1486

87

Add to List

Share
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5 
*/

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while(cur != null){ 
            while(cur.next != null && cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode = null;
            }
            cur = cur.next;
        }

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }
}