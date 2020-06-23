/**
 * 234. Palindrome Linked List
Easy

3037

349

Add to List

Share
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //the number of nodes of first part would be equal or more than the second part
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);

        while(newHead != null){
            if(newHead.val != head.val)
                return false;
            newHead = newHead.next;
            head = head.next;
        }

        return true;

    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
    
        return pre;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,3,2,1,1};
        ListNode head = NodeUtil.createList(arr, arr.length);
        // NodeUtil.printList(head);
        // head = new Solution().reverse(head);
        // NodeUtil.printList(head);

        System.out.println(new Solution().isPalindrome(head));
    }
}