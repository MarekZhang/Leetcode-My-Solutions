/**328. Odd Even Linked List
Medium

1743

292

Add to List

Share
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode connectNode = cur;

        while(true){
            if(prev.next == null || cur.next == null)
                break;
            prev.next = cur.next;
            cur.next = cur.next.next;

            prev = prev.next;
            cur = cur.next;
        }

        prev.next = connectNode;

        return head;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ListNode head = NodeUtil.createList(arr,arr.length);
        NodeUtil.printList(head);

        NodeUtil.printList(new Solution().oddEvenList(head));
    }
}