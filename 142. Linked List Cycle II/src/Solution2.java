public class Solution {
    //time complexity O(n) || space complexity O(1)
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
                slow = head;
                fast = fast.next;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        
        return null;
    }
}