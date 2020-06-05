/**83. Remove Duplicates from Sorted List
Easy

1404

106

Add to List

Share
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */


public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;

        while(cur != null){
            ListNode p = cur;
            int count = 0;
            while(p != null && p.val == cur.val){
                count++;
                p = p.next;
            }
            if(count > 1){
                prev.next = cur;
                cur.next = p;

            }
            prev = cur;
            cur = p;
            
        }

        head = dummyHead.next;
        dummyHead = null;

        return head;
    }

    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,4,4,5};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);

        ListNode head2 = deleteDuplicates(head);
        NodeUtil.printList(head2);
    }
}