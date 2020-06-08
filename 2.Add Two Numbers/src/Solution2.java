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

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode DummyHead = new ListNode(-1);
        DummyHead.next = new ListNode(0);
        ListNode cur = DummyHead.next;

        while(l1!=null || l2!=null){
            int l1Val;
            int l2Val;
            if(l1 == null)
                l1Val = 0;
            else{
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 == null)
                l2Val = 0;
            else{
                l2Val = l2.val;
                l2 = l2.next;
            }
            if(l1Val + l2Val + cur.val >= 10){
                cur.val = l1Val + l2Val + cur.val - 10;
                cur.next = new ListNode(1);
            }else{
                cur.val = l1Val + l2Val + cur.val;
                if(l1==null && l2==null)
                    break;
                cur.next = new ListNode(0);
            }
            
            cur = cur.next;
        }

        if(cur.val == 0)
            cur = null;
        
        ListNode result = DummyHead.next;
        DummyHead = null;

        return result;
    }

    public static void main(String[] args){
        int[] l1 = {1};
        int[] l2 = {9,9,9};
        ListNode node1 = NodeUtil.createList(l1, l1.length);
        ListNode node2 = NodeUtil.createList(l2, l2.length);

        ListNode result = new Solution2().addTwoNumbers(node1, node2);

        NodeUtil.printList(result);
    }
}