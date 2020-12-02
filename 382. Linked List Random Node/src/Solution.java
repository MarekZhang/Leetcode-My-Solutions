/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode node;
    public Solution(ListNode head) {
        node = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        ListNode start = node;
        int res = 0;
        int i = 1;
        while(start != null){
            if(rand.nextInt(i) + 1 == i) res = start.val;
            start = start.next;
            i++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */