/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //time complexity O(N) || space complexity O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA, lenB;
        lenA = lenB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while(dummyA != null){
            dummyA = dummyA.next;
            lenA++;
        }
        while(dummyB != null){
            dummyB = dummyB.next;
            lenB++;
        }
        int offset = Math.abs(lenA - lenB);
        if(lenA > lenB){
            while(offset-- > 0) headA = headA.next;
        }else{
            while(offset-- > 0) headB = headB.next;
        }
        while(headA != null && headB !=null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}