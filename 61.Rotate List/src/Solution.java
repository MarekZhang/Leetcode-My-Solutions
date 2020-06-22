/**
 * 61. Rotate List
Medium

1169

988

Add to List

Share
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null)
            return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode temptNode = dummyHead;
        int count = 0;
        while(temptNode.next != null){
            temptNode = temptNode.next;
            count++;
        }

        if(count==1)
            return head;

        if(k >= count){
            k %= count;
            return rotateRight(head, k);
        }
        
        //use two pointer to find the range to be rotated
        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for(int i = 0; i < k; i++)
            q = q.next;

        while(q.next != null){
            p = p.next;
            q = q.next;
        }

        ListNode newHead = p.next;
        p.next = null;
        q.next = head;
        dummyHead.next = newHead;

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,2};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().rotateRight(head, 2);
        NodeUtil.printList(head);
    }
}