/**
 * 148. Sort List
Medium

2603

128

Add to List

Share
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head.next;//相当于LinkedList size - 1
        while(fast!=null && fast.next!=null){//fast 每次需要移动两次， 相当于一共挪动了 (LinkedList.size - 1) / 2次
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //递归可以看成这时候返回的head，head2 及其后续已经有序，只需要把这两部分merge就完成了
         head = sortList(head);
         head2 = sortList(head2);
         return merge(head, head2);
    }

    private ListNode merge(ListNode head, ListNode head2){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode p1 = head;
        ListNode p2 = head2;

        while(p1!=null&&p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                //清空后续连接防止链表头尾相连
                p.next = null;
            }else{
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                p.next = null;
            }
        }

        if(p1!=null)
            p.next = p1;
        if(p2!=null)
            p.next = p2;

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }

    public static void main(String[] args){
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        ListNode  head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().sortList(head);
        NodeUtil.printList(head);
    }
}