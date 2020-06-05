/**86. Partition List
Medium

1143

283

Add to List

Share
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/
import java.util.*;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        
        //use collection to break all next keys
        List<ListNode> list = new ArrayList<>();
        ListNode tempt = head;
        while(tempt != null){
            list.add(tempt);
            tempt = tempt.next;
        }
        
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;

        //break all the 'next' key of Nodes
        for(ListNode node: list)
            node.next = null;


        for(ListNode node: list){
            if(node.val < x){ 
                cur1.next = node;
                cur1 = cur1.next;
            }else{
                cur2.next = node;
                cur2 = cur2.next;
            }
        }

        cur1.next = dummyHead2.next;
        dummyHead2 = null;

        ListNode result = dummyHead1.next;
        dummyHead1 = null;
        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,4,3,2,5,2};
        ListNode head = NodeUtil.createList(arr, 6);
        NodeUtil.printList(head);

        ListNode head2 = new Solution().partition(head, 3);
        NodeUtil.printList(head2);
    }
}