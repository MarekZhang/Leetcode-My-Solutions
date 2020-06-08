/**2. Add Two Numbers
Medium

8032

2047

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode DummyHead = new ListNode(-1);
        DummyHead.next = new ListNode(0);
        ListNode cur = DummyHead.next;

        while(true){

            if(l1.val + l2.val >= 10){
                cur.val = cur.val + l1.val + l2.val - 10;
                cur.next = new ListNode(1);
            }else{
                cur.val = cur.val + l1.val + l2.val;
                cur.next = new ListNode(0);
            }

            l1 = l1.next;
            l2 = l2.next;
            
            //the length of l1 and l2 is the same
            if(l1==null && l2==null){
                if(cur.next.val == 0)
                    cur.next = null;
                break;
            }

            cur = cur.next;
            //when the length of l1 and l2 is not equal
            if(l1 == null){
                cur.val = cur.val + l2.val;
                cur.next = l2.next;
                break;
            }
            else if (l2 == null){
                cur.val = cur.val + l1.val;
                cur.next = l1.next;
                break;
            }

        }

        ListNode result = DummyHead.next;
        DummyHead = null;

        return result;
    }

    public static void main(String[] args){
        int[] l1 = {5};
        int[] l2 = {5};
        ListNode node1 = NodeUtil.createList(l1, l1.length);
        ListNode node2 = NodeUtil.createList(l2, l2.length);

        ListNode result = new Solution().addTwoNumbers(node1, node2);

        NodeUtil.printList(result);
    }
}