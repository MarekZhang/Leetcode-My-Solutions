class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        //find the prev position of m and nex position of n
        for(int i = 0; i <= n - m + 1; i++ )
            fast = fast.next;

        for(int i = 1; i < m; i++){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode cur = slow.next;
        ListNode nex = cur;
        ListNode prev = fast;

        while(cur != fast){
            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }

        slow.next = prev;

        return dummyHead.next;
    }
}