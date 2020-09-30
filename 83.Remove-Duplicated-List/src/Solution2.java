class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode cur = head;
        ListNode nex = head.next;

        while(nex!=null){
            while(nex != null && nex.val == cur.val)
                nex = nex.next;
            cur.next = nex;
            cur = nex;
        }

        return head;
    }
}