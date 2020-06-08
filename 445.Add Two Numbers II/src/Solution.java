/**445. Add Two Numbers II
Medium

1330

147

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
import java.util.*;

 public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null){
            queue1.add(cur1.val);
            cur1 = cur1.next;
        }

        while(cur2 != null){
            queue2.add(cur2.val);
            cur2 = cur2.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        //进位
        int carry = 0;
        
        while(! queue1.isEmpty() || !queue2.isEmpty() || carry != 0){
            Integer tempt1 = queue1.pollLast();
            Integer value1;
            if(tempt1 == null)
                value1 = 0;
            else
                value1 = tempt1;

            Integer tempt2 = queue2.pollLast();
            Integer value2;
            if(tempt2 == null)
                value2 = 0;
            else
                value2 = tempt2;

            result.add((value1 + value2 + carry) % 10);

            carry = value1 + value2 + carry >= 10 ? 1 : 0;
        }


        
        while(! result.isEmpty()){
            cur.next = new ListNode(result.pollLast());
            cur = cur.next;
        }

        ListNode resultNode = dummyHead.next;
        dummyHead = null;

        return resultNode;
    }

    public static void main(String args[]){
        int[]arr1 = {5};
        int[]arr2 = {5};
        ListNode l1 = NodeUtil.createList(arr1, 1);
        ListNode l2 = NodeUtil.createList(arr2, 1);

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        NodeUtil.printList(result);
    }
    
 }