/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //time O(n) || space O(n)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))
                return true;
            
            set.add(head);
            head = head.next;
        }

        return false;
    }
}