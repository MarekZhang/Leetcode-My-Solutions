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

 public class Solution2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        while(cur2 != null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        //进位
        int carry = 0;
        
        while(! stack1.isEmpty() || !stack2.isEmpty() || carry != 0){

            int sum = 0;
            if(!stack1.isEmpty())
                sum += stack1.pop();
            
            if(!stack2.isEmpty())
                sum += stack2.pop();

            sum += carry;

            result.add((sum) % 10);

            carry = sum >= 10 ? 1 : 0;
        }


        
        while(! result.isEmpty()){
            cur.next = new ListNode(result.pop());
            cur = cur.next;
        }

        ListNode resultNode = dummyHead.next;
        dummyHead = null;

        return resultNode;
    }

    public static void main(String args[]){
        int[]arr1 = {5,1};
        int[]arr2 = {5,5};
        ListNode l1 = NodeUtil.createList(arr1, 2);
        ListNode l2 = NodeUtil.createList(arr2, 2);

        ListNode result = new Solution2().addTwoNumbers(l1, l2);
        NodeUtil.printList(result);
    }
    
 }