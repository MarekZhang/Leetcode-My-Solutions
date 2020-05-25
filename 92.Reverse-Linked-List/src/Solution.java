/**92. Reverse Linked List II
Medium

2103

135

Add to List

Share
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL */

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

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preNode = dummyHead;
        //find the previous node of the starter (m th) Node 找到第m个Node前第那个节点
        for(int i =1; i < m; i++){ 
            preNode = preNode.next;
        }
        //the start Node to inverse 反转的起始节点
         head = preNode.next;

         ListNode pre = null;
         ListNode cur = head;
         ListNode findlastNode = null;
         
         //the current start Node is the last Node after reversing
         ListNode lastNode = cur;
         for(int i = 0; i < n - m + 1; i++){

            ListNode nex = cur.next;
            if(i == n - m){
                findlastNode = nex; 
            }
            cur.next = pre;
            pre = cur;
            cur = nex;
         }
         //find the new start Node which is the last reverse Node before reversing
         ListNode newFirst = pre;

         lastNode.next = findlastNode;
         preNode.next = newFirst;

         ListNode result = dummyHead.next;
         dummyHead = null;

         return result;
        
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        reverseBetween(node1, 2, 4);
        
    }
}