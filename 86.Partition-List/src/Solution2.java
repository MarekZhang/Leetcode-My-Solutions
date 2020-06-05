
class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;

        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;
                cur1.next = null;
            }else{
                cur2.next = cur;
                cur2 = cur2.next;
                cur = cur.next;
                cur2.next = null;
            }
        }

        cur1.next = dummyHead2.next;
        dummyHead2 = null;
        ListNode result = dummyHead1.next;
        dummyHead1 = null;

        return result;

    }

    public static void main(String[] args){
        int[] arr = {1,4,3,2,5,2};
        ListNode head = NodeUtil.createList(arr, 6);
        NodeUtil.printList(head);

        ListNode head2 = new Solution2().partition(head, 3);
        NodeUtil.printList(head2);
    }
}