/**
 * 23. Merge k Sorted Lists
Hard

4691

286

Add to List

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
import java.util.*;

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length == 0) 
        return null;

      ListNode dummyHead = new ListNode(-1);
      ListNode cur = dummyHead;
      PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode n1, ListNode n2)-> n1.val - n2.val);
      //retrive all ListNode in the lists and store in a priority queue;
      for(ListNode node: lists){
        if(node != null)
          queue.add(node);
      }

      
      while(!queue.isEmpty()){
        ListNode tempt = queue.poll();
        if(tempt.next != null)
          queue.add(tempt.next);
        cur.next = tempt;
        cur = cur.next;
        cur.next = null;
      }

      ListNode res = dummyHead.next;

      return res;
  }

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[3];
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(5);

    ListNode node2 = new ListNode(1);
    node2.next = new ListNode(3);
    node2.next.next = new ListNode(4);

    ListNode node3 = new ListNode(2);
    node3.next = new ListNode(6);

    lists[0] = node1;
    lists[1] = node2;
    lists[2] = node3;

    ListNode res = new Solution().mergeKLists(lists);
    NodeUtil.printList(res);
  }
}