/**82. Remove Duplicates from Sorted List II
Medium

1486

103

Add to List

Share
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = dummyHead.next;

        while(cur != null){
            ListNode p = cur;
            int count = 0;
            while(p != null && p.val == cur.val){
                count ++;
                p = p.next;
            }

            if(count > 1)
                prev.next = p;
            else // count == 1
                prev = cur;
            cur = p;
        }

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);

        ListNode head2 = deleteDuplicates(head);
        NodeUtil.printList(head2);

    }

}
